package multithreading;

public class Deadlock {

//    void increment(){
//        acquire MUTEX_A;
//        acquire MUTEX_B;
//
//        // do work here
//        release MUTEX_A;
//        release MUTEX_A;
//
//    }
//
//    void decrement(){
//        acquire MUTEX_B;
//        acquire MUTEX_A;
//
//        // do work here
//        release MUTEX_B;
//        release MUTEX_A;
//
//    }

    private int counter = 0;
    private Object lock1 = new Object();
    protected Object lock2 = new Object();

    Runnable incrementer = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    incrementCounter();
                    System.out.println("incrementing " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    Runnable decrementer = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    decrementCounter();
                    System.out.println("Decrementing " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };


     void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Acquired lock1");
            Thread.sleep(100);

            synchronized (lock2) {
                counter++;
            }
        }
    }

     void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Lock 2 acquired");
            Thread.sleep(100);

            synchronized (lock1) {
                counter--;
            }
        }
    }

    public void runTests() throws InterruptedException {
        Thread thread = new Thread(incrementer);
        Thread thread1 = new Thread(decrementer);


        thread.start();

        // make sure thread 1 acquires the lock
        Thread.sleep(100);
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Done " + counter);
    }


}


class Demonstrator {
    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock = new Deadlock();

        deadlock.runTests();

    }
}