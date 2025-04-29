package multithreading;

import java.util.*;

public class DemoThreadUnsafe {
    // we will use to sleep the thresas randomly
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        // create object of unsafe count
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // set up a thread to increase the count 200 times
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                DemoThreadUnsafe.sleepRandomlyForLessThan0Sec();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                DemoThreadUnsafe.sleepRandomlyForLessThan0Sec();
            }
        });

        // run both threads
        t1.start();
        t2.start();

        // wait for both to complete
        t1.join();
        t2.join();

        badCounter.printFinalCount();
    }

    public static void sleepRandomlyForLessThan0Sec() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {

        }

    }
}


class ThreadUnsafeCounter {
    int count = 0;

    public  void increment() {
        count++;
    }

    public  void decrement() {
        count--;
    }

    void printFinalCount() {
        System.out.println("Count is " + count);
    }
}


// Resoluion
