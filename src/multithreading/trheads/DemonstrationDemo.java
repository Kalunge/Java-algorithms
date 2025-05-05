package multithreading.trheads;

import java.util.concurrent.atomic.*;

class DemonstrationDemo {
    public static void main(String args[]) throws Exception {
        UnsafeCounters usc = new UnsafeCounters();
        Thread[] tasks = new Thread[100];
        AtomicInteger totalCount = new AtomicInteger(0);

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++)
                    usc.increment();

                totalCount.getAndAdd(usc.counter.get());

                // System.out.println(usc.counter.get());
            });


            tasks[i] = t;
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            tasks[i].join();
        }

        System.out.println(totalCount.get());
    }
}

class UnsafeCounters {

    ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    void increment() {
        counter.set(counter.get() + 1);
    }
}