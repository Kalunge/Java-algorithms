package multithreading.trheads;

import java.util.*;
import java.util.concurrent.*;

public class ExecutorImplemntation {
    public static void main(String[] args) {

    }


    public void newbieImpl() {
        Order order = new Order(1, "newOrder");

        List<Order> orders = new ArrayList<>();

        orders.add(order);
        int ordersProcessd = 0;
        while (true) {
            if (ordersProcessd == orders.size()) {
                break;
            }
            for (Order order1 : orders) {
                Order.executeOrder(order1.getOrderId());
                ordersProcessd++;
            }


        }
    }


    public void newBieRefactor() {
        Order order = new Order(2, "NewstOrder");

        Thread thread = new Thread(() -> Order.executeOrder(order.getOrderId()));

        thread.start();
    }
}


class Order {
    private int orderId;
    private String orderName;

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public static void executeOrder(int orderId) {
        System.out.println("Order Processed id: " + orderId + " by " + Thread.currentThread().getName());    }

    public int getOrderId() {
        return orderId;
    }
}

class EfficientExecutor {
    public static void main(String[] args) {

    }

    public static void executeOrders() {
        int numOfExpectedOrders = 100;
        Executor executor = Executors.newFixedThreadPool(numOfExpectedOrders);

        while (true) {
            executor.execute(() -> Order.executeOrder(1));
        }


    }
}
