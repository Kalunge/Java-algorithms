package challenges;

import java.util.Arrays;

public class AlgoChallenges {

    public static boolean binarySearchTwo(int[] array, int item) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == array[mid]) {
                return true;
            } else if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] secondArr = {1};
        System.out.println(binarySearchTwo(arr, -15));
        Arrays.binarySearch(arr, 4);
    }
}
