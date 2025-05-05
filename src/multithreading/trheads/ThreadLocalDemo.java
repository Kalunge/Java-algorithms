package multithreading.trheads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ThreadLocalDemo {

    private int countUnsafe = 5;

    public static void main(String[] args) throws InterruptedException {
        // addThreadSafe(7);

        UnsafeCounter usc = new UnsafeCounter();
        Thread[] tasks = new Thread[100];
        AtomicInteger totalCount = new AtomicInteger(0);

        for (int i = 0; i < 100; i++) {
            Thread task = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    //usc.increment();
                    usc.incrementCounter();
                }
            });

            tasks[i] = task;
            task.start();
        }

        for (int i = 0; i < 100; i++) {
            tasks[i].join();
        }

        System.out.println(usc.counter.get());
    }

    static void addThreadSafe(int val) {
        int count = 5;
        count += val;

        System.out.println(count);
    }

    static void add() {
        ExecutorService threadPool = Executors.newFixedThreadPool(15);

        int count = 15;

        while (count != 0) {
            threadPool.submit(new Addition(count));
            count--;
        }
    }

}

class Addition implements Callable<Integer> {
    private int n;

    public Addition(int n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        return n * n;
    }
}

class UnsafeCounter {
    int count = 0;

    ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);


    void increment() {
        count = count + 1;
    }

    void incrementCounter() {
        counter.set(counter.get() + 1);
    }
}
