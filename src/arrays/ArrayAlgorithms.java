package arrays;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayAlgorithms {

    public static boolean linearSearch(int[] array, int item) {
        for (int current : array) {
            if (current == item) {
                return true; // we could return item as wel and return -1 or null in case it ain't found
            }
        }
        return false;
    }

    public static OptionalInt linearSearchTwo(int[] array, int item) {
        return Arrays.stream(array).filter(i -> i == item).findFirst();
    }


    public static boolean binarySearch(int[] array, int item) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            System.out.println(mid);
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
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(secondArr, 3));
        int rsult = 7 / 2;
        System.out.println(rsult);


//        linearSearchTwo(arr, 5).ifPresent(System.out::println); // -> 5
//        linearSearchTwo(arr, 9).ifPresent(System.out::println); // -> nothing

    }
}
