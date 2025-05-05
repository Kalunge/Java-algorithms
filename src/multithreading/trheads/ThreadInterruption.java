package multithreading.trheads;

public class ThreadInterruption {

    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();

        System.out.println("Main Thread sleeping at " + System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        innerThread.interrupt();
        System.out.println("Main Thread Exiting at " + System.currentTimeMillis() / 1000);

    }


    static class ExecuteMe implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread started");
            try {
                System.out.println("inner Thread Goes to sleep at " + System.currentTimeMillis() / 1000);
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Inner thread interupted at " + System.currentTimeMillis() / 1000);
            }
        }
    }
}
