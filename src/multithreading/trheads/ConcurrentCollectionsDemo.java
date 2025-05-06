package multithreading.trheads;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollectionsDemo {

    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<Integer, Integer> orderCounts = new ConcurrentHashMap<>();
        //HashMap<Integer, Integer> orderCounts = new HashMap<>();

        BlockingQueue<Integer> orderQueue = new ArrayBlockingQueue<>(100);

        // producers
        Thread producer = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    orderQueue.put(i);
                    System.out.println("Producer produced order " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

//        consumers
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Integer orderId = orderQueue.poll(1, TimeUnit.SECONDS);
                        orderCounts.compute(orderId, (k, v) -> v == null ? 1 : v + 1);
                        System.out.println(Thread.currentThread().getName() + " Processed order: " + orderId);
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        producer.start();
        producer.join();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Order counts, " + orderCounts);
    }
}
