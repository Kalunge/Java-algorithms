package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

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

    public static int[] findEvenNumbers(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr1) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        for (int num : arr2) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findEvenNumbersTwo(int[] arr1, int[] arr2) {
        IntPredicate isEvenPred = num -> num % 2 == 0;
        return Stream.of(arr1, arr2).flatMapToInt(Arrays::stream).filter(isEvenPred).toArray();

    }

    public static int[] reverseArray(int[] arr) {
        ArrayList<Integer> reversed = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            reversed.add(arr[i]);
        }

        return reversed.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] reverseArrayTwo(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }


    public static void reverseArrayThree(int[] arr) {
//        Swap beginning and ending items
        for (int i = 0; i <= arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static int[] rotateArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        int[] rotated = new int[numbers.length];
        rotated[numbers.length - 1] = numbers[0];

        for (int i = 1; i <= numbers.length - 1; i++) {
            rotated[numbers.length - 1] = numbers[0];
            rotated[i - 1] = numbers[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,1};
        int[] secondArr = {0, -3, -8, -35, 40, 20, 7};
        int[] rotated = rotateArray(arr);
        System.out.println(Arrays.toString(rotated));
    }
}
