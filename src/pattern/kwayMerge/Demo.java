package pattern.kwayMerge;

import java.util.*;

public class Demo {
    // medium of K sorted arrays


    public static int medianKArrays(int[] arrOne, int[] arrTwo, int[] arrThree, int[] arrFour) {
        int[] resOne = merge(arrOne, arrTwo);
        int[] resultTwo = merge(arrFour, arrThree);
        int[] result = merge(resOne, resultTwo);
        System.out.println(Arrays.toString(result));

        int mid;
        int median = 0;

        if (result.length % 2 != 0) {
            mid = result.length / 2;
            for (int i = 0; i < result.length; i++) {
                if (i == mid) {
                    median = result[mid];
                    break;
                }
            }
        } else {
            mid = result.length / 2;
            for (int j = 0; j < result.length; j++) {
                if (j == mid) {
                    median = (result[j] + result[j - 1]) / 2;
                    break;
                }
            }
        }

        return median;
    }

    public static int kThSmallest(int[] arrOne, int[] arrTwo, int[] arrThree, int[] arrFour, int k) {
        int[] res1 = merge(arrOne, arrTwo);
        int[] res2 = merge(arrThree, arrFour);
        int[] result = merge(res1, res2);

        int smallest = 0;
        for (int i = 0; i < result.length; i++) {
            if (i == k - 1) {
                smallest = result[i];
                break;
            }
        }

        return smallest;


    }

    public static int medianKArraysWithHeap(int[] arrOne, int[] arrTwo, int[] arrThree, int[] arrFour) {
        return 0;
    }

    public static int medianKArraysWithBinarySearch(int[] arrOne, int[] arrTwo, int[] arrThree, int[] arrFour) {
        return 0;
    }


    public static int[] merge(int[] arrOne, int[] arrTwo) {
        int n = arrOne.length + arrTwo.length;
        int[] result = new int[n];

        int i = 0, j = 0, l = 0;

        while (i < arrOne.length && j < arrTwo.length) {
            if (arrOne[i] < arrTwo[j]) {
                result[l++] = arrOne[i++];
            } else {
                result[l++] = arrTwo[j++];
            }
        }

        while (i < arrOne.length) {
            result[l++] = arrOne[i++];
        }

        while (j < arrTwo.length) {
            result[l++] = arrTwo[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 8, 12};
        int[] arr2 = new int[]{3, 6, 7};
        int[] arr3 = new int[]{1, 3, 4, 5, 9};
        int[] arr4 = new int[]{1, 6, 7};

        int median = medianKArrays(arr, arr2, arr3, arr4);
        System.out.println("median " + median);

        System.out.println("smallest");

        int smallest = kThSmallest(arr, arr2, arr3, arr4, 4); // expect = 3
        System.out.println(smallest);
    }
}
