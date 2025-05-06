package multithreading.trheads;

import java.util.concurrent.*;
import java.util.logging.*;

public class CyclicBarrierDemo extends Thread {
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is awaiting on barrier");
            cyclicBarrier.await();

            System.out.println(Thread.currentThread().getName() + " Has crossed the barrier");
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(CyclicBarrierDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class MainBarrier {


    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All parties have arrived at the barrier, let us continue execution");
            }
        });

        CyclicBarrierDemo task1 = new CyclicBarrierDemo(cb);
        CyclicBarrierDemo task2 = new CyclicBarrierDemo(cb);
        CyclicBarrierDemo task3 = new CyclicBarrierDemo(cb);

        task1.start();
        task2.start();
        task3.start();
    }
}