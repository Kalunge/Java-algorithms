package multithreading;

public class Reordering {
    int sharedA = 0;
    int sharedB = 0;


    public void methodOne() {
        int localA;
        localA = sharedA;
        sharedB = 1;

        System.out.println("Local A = " + localA);
    }

    public void methodB() {
        int localB;
        localB = sharedB;
        sharedA = 2;
        System.out.println("Local B " + localB);

    }

    public static void main(String[] args) throws InterruptedException {
        Reordering reordering = new Reordering();

        Thread thread1 = new Thread(reordering::methodOne);

        Thread thread2 = new Thread(reordering::methodB);


        thread1.start();
        thread2.start();

        thread2.join();
        thread2.join();
    }
}
