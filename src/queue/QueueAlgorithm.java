package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAlgorithm {

    public static void printBinary(int n) {
        if (n <= 0) {
            System.out.println();
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 0; i < n; i++) {
            int current = queue.remove();
//            System.out.println(queue);
            System.out.println(current);

            queue.add(current * 10);
            queue.add((current * 10) + 1);

        }

        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(20);

//
        printBinary(10);

    }
}
