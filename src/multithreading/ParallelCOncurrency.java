package multithreading;

import java.util.*;

public class ParallelCOncurrency {
    static long sum = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        sumSequentially();
        sumConcurrently();
        sumInParallel();
    }

    private static void sumSequentially() {

        long[] numbers = new long[500_000_000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        long start = System.currentTimeMillis();
        long sum = 0;
        for (long num : numbers) {
            sum += num;
        }

        long end = System.currentTimeMillis();

        System.out.println("Summig Sequentially took " + (end - start) + " ms");

    }

    private static void sumConcurrently() throws InterruptedException {
        long[] numbers = new long[500_000_000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        long start = System.currentTimeMillis();
        int length = numbers.length;
        Thread t1 = new Thread(() -> add(numbers, 0, length / 2));
        Thread t2 = new Thread(() -> add(numbers, length / 2, length));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println("Threading took " + (end - start) + " ms");
    }

    static void add(long[] numbers, int start, int end) {
        long localSUm = 0;
        for (int i = start; i < end; i++) {
            localSUm += numbers[i];
        }

        synchronized (lock) {
            sum += localSUm;
        }
    }


    // parallelism
    private static void sumInParallel() {
        long[] numbers = new long[500_000_000];

        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        long start = System.currentTimeMillis();

        Arrays.stream(numbers).parallel().sum();

        long end = System.currentTimeMillis();

        System.out.println("Parallel summing took " + (end - start) + " ms");
    }


}
