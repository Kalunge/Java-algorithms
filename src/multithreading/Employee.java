package multithreading;

public class Employee {

    private String name;
    private final Object lock = new Object();

    public synchronized void setName(String name) {
        this.name = name;
    }


    public synchronized void resetName() {
        this.name = "";
    }


    // same as adding syncronized to definition as it is locked on this object
    public String getName() {
        synchronized (this) {
            return this.name;
        }
    }

    // locked on another object thus can be executed/accessed alongside reset and set however reset and set can only be accessed by one thread at a time
    public String getNameLockedOnAnotherObj() {
        synchronized (lock) {
            return this.name;
        }
    }
}

class IncorrectSynchronization {
    Boolean flag = new Boolean(true);

    public void example() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                synchronized (flag) {
                    try {
                        while (flag) {
                            System.out.println("First thread about to sleep");
                            Thread.sleep(5000);
                            System.out.println("Woke up and about to invoke wait()");
                            flag.wait();
                        }
                    } catch (InterruptedException ie) {

                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            flag = false;
            System.out.println("Boolean assignment done.");
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
    }
}
