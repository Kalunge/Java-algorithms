package pattern.subsets;

import java.util.*;

public class Demo {
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();

        for (int num : arr) {
            List<Integer> subset = new ArrayList<>();
            for (List<Integer> sub : subsets) {
                subset.addAll(sub);
                subset.add(num);
            }
            subsets.add(subset);
        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
