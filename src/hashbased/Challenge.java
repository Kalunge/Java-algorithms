package hashbased;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Challenge {

    public static List<Integer> findMissingElements(int[] first, int[] second) {
        List<Integer> missingElements = new ArrayList<>();

        HashSet<Integer> hashSet = new HashSet<>();

        for (int item : second) {
            hashSet.add(item);
        }

        for (int item : first) {
            if (!hashSet.contains(item)) {
                missingElements.add(item);
            }
        }

        return missingElements;

    }

    public static void displayElementFrequency(int[] array) {
        HashMap<Integer, Integer> elementCounts = new HashMap<>();

        for (int item : array) {
            if (!elementCounts.containsKey(item)) {
                elementCounts.put(item, 1);
            } else {
                elementCounts.put(item, elementCounts.get(item) + 1);
            }
        }


        elementCounts.forEach((key, value) -> System.out.println(key + " : " + value));

    }

    public static void main(String[] args) {
//        findMissingElements(new int[]{1, 2, 3, 4}, new int[]{1, 3}).forEach(System.out::println);

//        findMissingElements(new int[]{8, 0, 1, 7, 3}, new int[]{15, 7, 8, 0, 2}).forEach(System.out::println);

        int[] arr = {1, 2, 3, 3, 4, 4, 5, 5, 5, 5, 67, 7};
        displayElementFrequency(arr);
    }
}
