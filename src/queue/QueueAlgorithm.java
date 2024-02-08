package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAlgorithm {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(20);

        int removedItem = queue.remove();
        System.out.println(removedItem);
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println("removing");

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}
