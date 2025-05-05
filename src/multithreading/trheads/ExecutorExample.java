package multithreading.trheads;

import java.util.concurrent.*;


public class ExecutorExample {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        DumbExecutor executor = new DumbExecutor();
        executor.execute(task);
    }

}

class DumbExecutor implements Executor {

    public void execute(Runnable runnable) {
        Thread newThread = new Thread(runnable);
        newThread.start();
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("My Task is now being executed");
    }
}