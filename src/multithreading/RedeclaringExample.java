package multithreading;

public class RedeclaringExample {

    static class MyObject {
        int x;
    }

    MyObject obj1;
    MyObject obj2;

    void method1() {
        MyObject read1 = obj1;
        int read2 = obj1.x;

        MyObject read3 = obj2;
        int read4 = read3.x;
        int read5 = obj1.x;
    }

    void method2() {
        MyObject read6 = obj1;
        read6.x = 3;
    }
}


class Reorder {
    int x;

    void method1() {
        int read1 = x;
        x = 1;

        System.out.println("read1 is " + read1);
    }

    void method2() {
        int read2 = x;
        x = 2;
        System.out.println("read2 is " + read2);
    }


    public static void example() throws InterruptedException {
        Reorder reorder = new Reorder();
        Thread thread1 = new Thread(reorder::method1);
        Thread thread2 = new Thread(reorder::method2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("X is " + reorder.x);
    }

    public static void main(String[] args) throws InterruptedException {
        example();
    }
}