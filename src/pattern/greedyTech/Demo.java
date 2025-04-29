package pattern.greedyTech;

import java.util.*;

public class Demo {
    public static int loadingMaximumWeights(int[] weights, int capacity) {
        Arrays.sort(weights);
        int total = 0;
        int count = 0;

        for (int weight : weights) {
            if (total + weight < capacity) {
                total += weight;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
