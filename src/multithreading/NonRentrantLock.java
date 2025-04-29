package multithreading;

class NonReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        NonRentrantLock nonRentrantLock = new NonRentrantLock();

        // first locking would be succesful
        nonRentrantLock.lock();
        System.out.println("Acquired first lock");

        //nonRentrantLock.unlock();

        // second locking results in a self deadlock
        System.out.println("Trying to acquire the second lock");
        nonRentrantLock.lock();
        System.out.println("Acquired second lock");

    }
}

public class NonRentrantLock {
    boolean isLocked;

    public NonRentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }

        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }

}
