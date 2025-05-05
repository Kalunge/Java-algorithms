package multithreading.trheads;

public class Demonstration {

//    public static void main(String[] args) throws InterruptedException {
//        ExecuteMe executeMe = new ExecuteMe();
//        Thread thread = new Thread(executeMe);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A trhead a differenct way");
//            }
//        });
//
//        ExtendThread thread5 = new ExtendThread();
//
//
//        Thread thread2 = new Thread(() -> System.out.println("Thread via Lambda"));
//
//
//        thread.start();
//        thread2.start();
//
//        thread5.start();
//        thread5.join();
//
//        thread1.start();
//    }

    public static void main(String[] args) {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.setDaemon(true);
        innerThread.start(); // May se some output due to main trhead context switching otherwise no output as main thread that runs this thread terminates after executing
    }
}


class ExecuteMe implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("Say Hello over and over again");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

// extend Thread class

class ExtendThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread from extending Thread class");
    }
}