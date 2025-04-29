package pattern.whattotrack;

import java.util.*;

public class Demo {

    // find the most frequent element

    public static int mostFrequent(int[] arr) {
        // add item with its occurrence in the hashmap
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int item : arr) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        // iterate over the hash map to find the maximum occurrence
        int max = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > max) {
                max = key;
            }
        }

        return max;


    }

    public static List<Integer> occurOnce(int[] arr) {
        // add occurencies in a hashmap
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i : arr) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        // check items whose value is 1 from the hashmao
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == 1) {
                result.add(key);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] testArr = new int[]{1, 1, 2, 3, 4, 4, 4, 5, 6, 6, 6, 7, 8, 9, 9};

        int result = mostFrequent(testArr);
        System.out.println(result);

        List<Integer> singleOccurence = occurOnce(testArr);
        System.out.println(singleOccurence);
    }
}
