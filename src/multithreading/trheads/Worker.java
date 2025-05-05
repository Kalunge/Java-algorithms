package multithreading.trheads;

import java.util.concurrent.*;

public class Worker extends Thread {

    private CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch, String name) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().getName() + " Started");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // handle execption
            e.printStackTrace();
        }

        System.out.println("Worker " + Thread.currentThread().getName() + " Finished");

        countDownLatch.countDown();
    }
}

class Master extends Thread {

    public Master(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker A = new Worker(countDownLatch, "A");
        Worker B = new Worker(countDownLatch, "B");

        A.start();
        B.start();

        countDownLatch.await();

        Master D = new Master("Master executed");
        D.start();

    }
}