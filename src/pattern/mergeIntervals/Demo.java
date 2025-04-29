package pattern.mergeIntervals;

import java.util.*;

public class Demo {
    public static int[][] merged(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }


        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lasInterval = merged.get(merged.size() - 1);
            int[] currentInterval = intervals[i];

            if (lasInterval[1] >= currentInterval[0]) {
                lasInterval[1] = Math.max(currentInterval[1], lasInterval[1]);
            } else {
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);

    }

//    public static int[][] merge(int[][] intervals) {
//        // If there are no intervals, return an empty array
//        if (intervals.length == 0) {
//            return new int[0][];
//        }
//
//        List<int[]> merged = new ArrayList<>();
//
//        // Add the first interval to the merged list
//        merged.add(intervals[0]);
//
//        // Iterate through the intervals
//        for (int i = 1; i < intervals.length; i++) {
//            // Get the last interval in the merged list
//            int[] lastInterval = merged.get(merged.size() - 1);
//            int[] currentInterval = intervals[i];
//
//            // If the current interval overlaps with the last interval, merge them
//            if (currentInterval[0] <= lastInterval[1]) {
//                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
//            } else {
//                // Otherwise, add the current interval to the merged list
//                merged.add(currentInterval);
//            }
//        }
//
//        // Convert the merged list to an array and return it
//        return merged.toArray(new int[merged.size()][]);
//    }

    public static boolean canAttend(int[][] meetings) {
        if (meetings.length <= 1) {
            return true;
        }

        //  Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i - 1][1] > meetings[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 7}, {9, 12}, {10, 14}, {15, 17}, {16, 18}};
        int[][] result = merged(intervals);

        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(canAttend(intervals)); // false
        System.out.println(canAttend(new int[][]{{1, 4}, {5, 7}, {9, 12}})); // true
    }
}
