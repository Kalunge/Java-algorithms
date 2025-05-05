package multithreading.trheads;

import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        List<Order> orders = List.of(new Order(1, "Order1"), new Order(2, "Order2"), new Order(3, "Order3"));


        // fixed thread pool
        System.out.println("fixed thread pool");
        double startTime = System.currentTimeMillis();
        ExecutorService fixed = Executors.newFixedThreadPool(2);
        for (Order o : orders) {
            fixed.submit(() -> Order.executeOrder(o.getOrderId()));
        }

        fixed.shutdown();
        fixed.awaitTermination(5, TimeUnit.SECONDS);
        double endTime = System.currentTimeMillis();
        System.out.println("finished executing in " + (endTime - startTime) + " ms");
        System.out.println();

        // cahced
        double startTimeCahed = System.currentTimeMillis();
        ExecutorService cached = Executors.newCachedThreadPool();
        System.out.println("Cached executor");

        for (Order o : orders) {
            cached.submit(() -> Order.executeOrder(o.getOrderId()));
        }
        cached.shutdown();
        cached.awaitTermination(5, TimeUnit.SECONDS);
        double endtimeCahed = System.currentTimeMillis();
        System.out.println("ended execution in " + (endtimeCahed - startTimeCahed) + " ms");
        System.out.println();

        // single threadpool
        double startSingle = System.currentTimeMillis();
        ExecutorService single = Executors.newSingleThreadExecutor();
        System.out.println("Single thread pool");
        for (Order o : orders) {
            single.submit(() -> Order.executeOrder(o.getOrderId()));
        }

        single.shutdown();
        single.awaitTermination(5, TimeUnit.SECONDS);
        double endTimeSingle = System.currentTimeMillis();
        System.out.println("ended execution in " + (endTimeSingle - startSingle) + " ms");
        System.out.println();

        // work stealing
        double startStealing = System.currentTimeMillis();
        System.out.println("Work stealing thread");
        ExecutorService workStealing = Executors.newWorkStealingPool();

        for (Order o : orders) {
            workStealing.submit(() -> Order.executeOrder(o.getOrderId()));
        }

        workStealing.shutdown();
        workStealing.awaitTermination(5, TimeUnit.SECONDS);
        double endStealing = System.currentTimeMillis();
        System.out.println("Finished execution in " + (endStealing - startStealing) + " ms");
        System.out.println();

        // sheduled
        double startSchedule = System.currentTimeMillis();
        System.out.println("Scheduled Thread");
        ScheduledExecutorService shceduled = Executors.newScheduledThreadPool(1);
        shceduled.schedule(() -> Order.executeOrder(4), 5, TimeUnit.SECONDS);
        shceduled.shutdown();
        shceduled.awaitTermination(5, TimeUnit.SECONDS);
        double endSchedule = System.currentTimeMillis();
        System.out.println("Finished execution in " + (endSchedule - startSchedule) + " ms");


        System.out.println("Program is exiting");

    }
}
