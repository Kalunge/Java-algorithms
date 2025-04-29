import java.util.*;

public class Demo {

    public static int candies(int[] A, int[] B) {
        int n = A.length;
        int maxCandiesPerShop = n / 2;

        Set<Integer> shopA = new HashSet<>();
        Set<Integer> shopB = new HashSet<>();

        for (int candy : A) {
            shopA.add(candy);
        }

        for (int candy : B) {
            shopB.add(candy);
        }

        Set<Integer> result = new HashSet<>();

        int aCount = 0;

        for (int candy : shopA) {
            if (aCount < maxCandiesPerShop) {
                result.add(candy);
                aCount++;
            }
        }

        int bCount = 0;
        for (int candy : shopB) {
            if (bCount < maxCandiesPerShop && !result.contains(candy)) {
                result.add(candy);
                bCount++;
            }
        }

        return result.size();
    }


    public static boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4};
//        int[] B = {3, 3, 3, 7};
        int[] A = {2, 2, 2, 2, 2, 2};
        int[] B = {7, 4, 2, 5, 1, 2};

        System.out.println(candies(A, B));
        System.out.println("Square sticks result ");

        System.out.println(squareSticks(10, 21));
        System.out.println(squareSticks(13, 11));
        System.out.println(squareSticks(2, 1));
        System.out.println(squareSticks(1, 8));

        System.out.println(" Debug results");

        int[] values = {1, 1, 4, 4};  //, K = 4 and L = 2, the function should return true
        int[] values1 = {1, 1, 2, 4}; // , K = 4 and L = 1, the function should return false.
        int[] values2 = {4, 2, 5}; //, K = 5 and L = 2, the function should return true.


        System.out.println(solution(values, 4, 2));
        System.out.println(solution(values1, 4, 1));
        System.out.println(solution(values2, 5, 2));


    }


    public static boolean solution(int[] values, int K, int L) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int val : values) {
            if (val > K) {
                return false;
            }

            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);

            if (frequencyMap.get(val) > L) {
                return false;
            }
        }
        return true;
    }


    public static int squareSticks(int A, int B) {
        int left = 1;
        int right = A == 1 ? B : Math.min(A, B);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pieces = (A / mid) + (B / mid);

            if (pieces >= 4) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}