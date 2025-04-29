package multithreading;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MissedSignal {

    public static void main(String[] args) throws InterruptedException {
        //example();
        exampleSemaphore();
    }

    public static void example() throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread signaller = new Thread(() -> {
            lock.lock();
            condition.signal();
            System.out.println("Signal sent");
            lock.unlock();
        });


        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("Signal received");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

        });

        signaller.start();
        signaller.join();


        waiter.start();
        waiter.join();

        // signal will not be received as was sent before waiter started
        System.out.println("Program exiting");
    }


    // Refactor to use semaphore
    public static void exampleSemaphore() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        Thread signaller = new Thread(() -> {
            semaphore.release();
            System.out.println("Signal sent");
        });


        Thread waiter = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Signal received");
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }

        });

        signaller.start();
        signaller.join();

        Thread.sleep(500);

        waiter.start();
        waiter.join();

        // signal will not be received as was sent before waiter started
        System.out.println("Program exiting");
    }
}
