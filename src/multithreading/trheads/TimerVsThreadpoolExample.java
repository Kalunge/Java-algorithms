package multithreading.trheads;

import java.util.*;

public class TimerVsThreadpoolExample {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        TimerTask badTask = new TimerTask() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        TimerTask goodTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello, I am a well beahved task");
            }
        };

//        timer.schedule(badTask, 50);
//        timer.schedule(goodTask, 100);

        TimerTask anotehrBadTask = new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException("Broke down");
            }
        };

        TimerTask anotherGoodTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Yet another well behaved task");
            }
        };

//        timer.schedule(anotehrBadTask, 10);
//        Thread.sleep(500);
        timer.schedule(anotherGoodTask, 10, 100);
        Thread.sleep(500);
        timer.cancel();
    }


}
