package multithreading;

import java.util.concurrent.*;

public class SemaphoreInJava {

    public static void main(String[] args) throws InterruptedException {
//        badExample();
        example();
    }

    public static void badExample() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);


        Thread badThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    // handle exception
                }

                throw new RuntimeException();

                // unreachable statement
                // semaphore.release();
            }
        });


        badThread.start();
        Thread.sleep(1000);


        Thread goodThread = new Thread(() -> {
            System.out.println("Good trhead waiting to be signalled");
            try {
                semaphore.acquire();

            } catch (InterruptedException e) {

            }
        });

        badThread.join();
        goodThread.start();
        goodThread.join();

        System.out.println("Program exiting");
    }

    public static void example() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);


        Thread badThread = new Thread(() -> {
            while (true) {
                try {
                    try {
                        semaphore.acquire();
                        throw new RuntimeException();
                    } catch (RuntimeException e) {
                        return;
                    } finally {
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    // handle exception
                }

                throw new RuntimeException();

                // unreachable statement
                // semaphore.release();
            }
        });


        badThread.start();
        Thread.sleep(1000);


        Thread goodThread = new Thread(() -> {
            System.out.println("Good trhead waiting to be signalled");
            try {
                semaphore.acquire();

            } catch (InterruptedException e) {

            }
        });

        badThread.join();
        goodThread.start();
        goodThread.join();

        System.out.println("Program exiting");
    }
}
