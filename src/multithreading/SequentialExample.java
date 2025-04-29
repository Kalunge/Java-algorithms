package multithreading;

import java.util.concurrent.*;

public class SequentialExample {

    public static void main(String[] args) throws InterruptedException {
        single();
        multiThreaded();
        asynchronous();
    }

    // sequenctial not concurrency

    public static void single() {
        long start = System.currentTimeMillis();

        for (int i = 0; i <= 5; i++) {
            performTask(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("sequential excution took " + (end - start) + " ms");
    }


    // Multithreading - concurrency with Threads

    public static void multiThreaded() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[5];


        for (int i = 0; i < 5; i++) {
            int taskId = i + 1;
            threads[i] = new Thread(() -> performTask(taskId));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Multithreading took " + (end - start) + " ms");
    }


    // Asyncrronous - COncurrency wit CompleteableFuture

    private static void asynchronous() {
        long start = System.currentTimeMillis();
        CompletableFuture<Void>[] futures = new CompletableFuture[5];

        for (int i = 0; i < 5; i++) {
            int taskId = i + 1;
            futures[i] = CompletableFuture.runAsync(() -> performTask(taskId));
        }

        CompletableFuture.allOf(futures).join();

        long end = System.currentTimeMillis();
        System.out.println("Async took " + (end - start) + " ms");
    }


    static void performTask(int taskId) {
        try {
            System.out.println("Task " + taskId + " started");
            Thread.sleep(100);
            System.out.println("task " + taskId + " Completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
