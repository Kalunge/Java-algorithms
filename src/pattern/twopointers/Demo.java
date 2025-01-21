package pattern.twopointers;

import java.util.Arrays;

public class Demo {
    public static void reverseArray(int[] arr) {
        // two pointers one from the end and one from the start
        // loop ends wehn both pointers meet
        // at every step swap the elements
        // check for edge cases
        // array is null
        //

        if (arr == null) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;


            start++;
            end--;
        }
    }

    public static int[] pairSum(int[] arr, int target) {
        if (arr == null) {
            return new int[]{};
        }

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int currentTotal = arr[start] + arr[end];

            if (currentTotal == target) {
                return new int[]{arr[start], arr[end]};
            } else if (currentTotal < target) {
                start++;
            } else {
                end--;
            }
        }


        return new int[]{};
    }

    public static boolean checkPalindorme(String s) {
        return false;
    }

    public static void main(String[] args) {
        int[] toreverse = new int[]{1, 2, 3, 4, 5, 6};

        reverseArray(toreverse);

        for (int item : toreverse) {
            System.out.print(item + " ");
        }

        System.out.println();

        int[] pairSum = new int[]{1, 2, 3, 4, 5, 6};


        int[] result = pairSum(pairSum, 8);
        System.out.println(Arrays.toString(result));
    }
}
