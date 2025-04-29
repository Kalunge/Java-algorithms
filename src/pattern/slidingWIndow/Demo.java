package pattern.slidingWIndow;

import java.util.*;

public class Demo {
    public static int maxSumOfSubArray(int[] array, int k) {
        int maxSum = 0;
        int windowSUm = 0;

        for (int i = 0; i < k; i++) {
            windowSUm += array[i];
        }

        maxSum = windowSUm;

        for (int i = k; i < array.length; i++) {
            windowSUm += array[i] - array[i - k];
            maxSum = Math.max(windowSUm, maxSum);
        }

        return maxSum;

    }

    public static int maxSubString(String str) {
        int left = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {
            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    // naive approaches

    public static int maxSumOfSubArrayNaive(int[] array, int k) {
        int maxSUm = 0;


        for (int i = 0; i <= array.length - k; i++) {
            int currentSum = 0;
            for (int j = i; j < i + k; j++) {
                currentSum += array[j];
            }

            maxSUm = Math.max(currentSum, maxSUm);
        }

        return maxSUm;
    }


    public static int maxSubStringNaive(String str) {
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (set.contains(str.charAt(j))) {
                    break;
                }

                set.add(str.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, -1, 9, 7, -3, 5};
        int result = maxSumOfSubArrayNaive(array, 4); // 18
        System.out.println(result);

        String sentence = "abcdbea";
        System.out.println(maxSubStringNaive(sentence)); // 5
    }
}
