package multithreading;

import java.util.*;


public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        RaceCondition1.runTest();
    }
}

class RaceCondition1 {
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {
        int i = 1000000;
        while (i != 0) {
            if (i % 5 == 0) {
                if (i % 5 != 0) {
                    System.out.println(i);
                }
            }

            i--;
        }
    }

    void modifier() {
        int i = 1000000;

        while (i != 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {
        RaceCondition1 rc = new RaceCondition1();
        Thread thread = new Thread(rc::printer);
        Thread thread1 = new Thread(rc::modifier);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }
}
