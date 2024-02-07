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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        linearSearchTwo(arr, 5).ifPresent(System.out::println); // -> 5
        linearSearchTwo(arr, 9).ifPresent(System.out::println); // -> nothing

    }
}
