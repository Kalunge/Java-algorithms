package multithreading.trheads;

public class SleepThreadExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutMe executMe = new ExecutMe();
        Thread innerThread = new Thread(executMe);
        innerThread.start();
        innerThread.join(); // minus thus the main thread may exit before the inner thread is done however it will still complete its execution as it is not marked as a daemon thread
        System.out.println("Main thread Exiting");

    }


    static class ExecutMe implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello from Execute me");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // swallow exception
            }
        }
    }
}
