package pattern.modifiedBs;

import java.util.*;

public class Demo {

    public static int[] findFirstAndLastOccurrences(int[] arr, int target) {
        int first = findPosition(arr, target, true);
        int last = findPosition(arr, target, false);

        return new int[]{first, last};
    }

    public static int findPosition(int[] arr, int target, boolean findFirst) {

        int result = -1;

        if (arr == null || arr.length == 0) {
            return result;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                result = mid;

                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static int integerSquareRoot(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int result = 0;

        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid == x) {
                result = mid;
                return result;
            }

            if (mid * mid < x) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return result;
    }


    public static void main(String[] args) {
        int[] arr = {3, 9, 9, 9, 11, 12};
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = findFirstAndLastOccurrences(arr, 9); // expect [1,3]
        int[] result2 = findFirstAndLastOccurrences(nums, 8); // expect[3, 4]
        int[] result3 = findFirstAndLastOccurrences(nums, 18); // expect[-1, -1]
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));

        System.out.println("Integer square root of " + 30 + " is: " + integerSquareRoot(30)); // expect 5
        System.out.println("Integer square root of " + 36 + " is: " + integerSquareRoot(36)); // expect 6
        System.out.println("Integer square root of " + 49 + " is: " + integerSquareRoot(49)); // expect 7
    }
}
