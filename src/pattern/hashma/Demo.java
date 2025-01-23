package pattern.hashma;

import java.util.*;

public class Demo {

    public static int[] pairSUm(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];

            if (map.containsKey(difference)) {
                return new int[]{arr[i], difference};
            }

            map.put(arr[i], i);
        }

        return new int[]{};
    }


    public static Map<String, Integer> wordOcuurence(String sentence) {
        String processed = sentence.replaceAll("[^a-zA-Z0-9\\s]", "");

        Map<String, Integer> frequency = new HashMap<>();

        for (String s : processed.split(" ")) {
            if (frequency.containsKey(s)) {
                frequency.put(s, frequency.get(s) + 1);
            } else {
                frequency.put(s, 1);
            }
        }

        return frequency;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = pairSUm(arr, 11);

        System.out.println(Arrays.toString(result));
        Map<String, Integer> resultMap = wordOcuurence("This is a test. This test is only a test.");


        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}
