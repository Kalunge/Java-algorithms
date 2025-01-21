package pattern.fastandslow;

import java.util.*;

public class Demo {

    public static boolean isCyclic(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int fast = 0;
        int slow = 0;

        while (true) {
            slow = nextIndex(arr, slow);
            fast = nextIndex(arr, fast);

            if (fast != -1) {
                fast = nextIndex(arr, fast);
            }

            // if hare gets outside, there is no cycle
            if (fast == -1 || slow == -1) {
                return false;
            }

            // cycle detected
            if (fast == slow) {
                return true;
            }
        }
    }


    public static int nextIndex(int[] arr, int currentIndex) {
        if (currentIndex < 0 || currentIndex >= arr.length) {
            return -1; // our of bounds
        }

        int next = arr[currentIndex];

        if (next < 0 || next >= arr.length) {
            return -1; // invalid index
        }

        return next;
    }

    public static boolean hasCycle(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }


        for (int start = 0; start < arr.length; start++) {
            Set<Integer> visited = new HashSet<>();
            int currentIndex = start;

            while (currentIndex >= 0 && currentIndex < arr.length) {
                if (visited.contains(currentIndex)) {
                    return true;
                }

                visited.add(currentIndex);

                currentIndex = arr[currentIndex];
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1}; // Contains a cycle
        int[] arr2 = {1, 2, 3, 4}; // No cycle
        int[] arr3 = {1, 2, 0, 4}; // Contains a cycle

        System.out.println("Array 1 has cycle: " + hasCycle(arr1)); // true
        System.out.println("Array 2 has cycle: " + hasCycle(arr2)); // false
        System.out.println("Array 3 has cycle: " + hasCycle(arr3)); // true
    }
}
