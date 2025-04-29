package pattern.whattotrack;

import java.util.*;

public class Challenge {
    public static int maximumCandies(int[] A, int[] B) {
        int n = A.length;
        int maxCandies = n / 2;

        Set<Integer> shopAcandies = new HashSet<>();
        Set<Integer> shopBcandies = new HashSet<>();

        for (int candy : A) {
            shopAcandies.add(candy);
        }

        for (int candy : B) {
            shopBcandies.add(candy);
        }

        Set<Integer> purchased = new HashSet<>();

        int shopACount = 0;
        for (int candy : shopAcandies) {
            if (shopACount < maxCandies) {
                purchased.add(candy);
                shopACount++;
            }


        }

        int shopBCount = 0;

        for (int candy : shopBcandies) {
            if (shopBCount < maxCandies && !purchased.contains(candy)) {
                purchased.add(candy);
                shopBCount++;
            }


        }


        return purchased.size();

    }


    public static int maximumSquares(int A, int B) {
        int left = 1;
        int right = Math.min(A, B);


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

    public static int squareRoot(int n) {
        int start = 0;
        int end = n;
        int result = 0;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            result = mid;

            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] shopA = {2, 2, 2, 2, 2, 2};
        int[] shopB = {7, 4, 2, 5, 1, 2};

//        int[] A = {1, 2, 3, 4};
//        int[] B = {3, 3, 3, 7};

        int[] A = {3, 1, 2, 3};
        int[] B = {3, 2, 1, 4};

//        int max = maximumCandies(A, B);
//        System.out.println(max);

//        System.out.println(squareRoot(16));
//        System.out.println(squareRoot(17));
//        System.out.println(squareRoot(1));
//
//        System.out.println(solution(10, 21)); // expect 7
//        System.out.println(solution(13, 11)); // expect 5
//        System.out.println(solution(2, 1)); // expect 0
//        System.out.println(solution(1, 8)); // expect 2

        int[] values = {1, 1, 4, 4};  // K = 4 and L = 2,  true
        int[] values2 = {1, 1, 2, 4}; //, K = 4 and L = 1,  false
        int[] values3 = {4, 2, 5};// , K = 5 and L = 2,  true


        System.out.println(solution5(values, 4, 2));
        System.out.println(solution5(values2, 4, 1));
        System.out.println(solution5(values3, 5, 2));
    }


    public static boolean occurrences(int[] values, int K, int L) {
        for (int val : values) {
            if (val > K) {
                return false;
            }
        }


        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int val : values) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        }

        for (int num : values) {
            if (frequencyMap.get(num) > L) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution5(int[] values, int K, int L) {
        int n = values.length;
        for (int i = L; i < n; i++) {
            if (values[i] > K) return false;
            if (values[i - L] == values[i - L]) {
                return false;
            }
        }

        return values[n - 1] == K;
    }

    public static boolean solution6(int[] values, int K, int L) {
        // Frequency map to count occurrences of numbers in the range [1..K]
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int value : values) {
            // Check if the number is out of the allowed range
            if (value > K) {
                return false;
            }

            // Increment the frequency of the current number
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);

            // Check if the current number exceeds the allowed frequency L
            if (frequencyMap.get(value) > L) {
                return false;
            }
        }

        return true;
    }

    public static int solution(int A, int B) {
        // Binary search bounds: The maximum possible side length is the minimum of A and B.
        int left = 1;
        int right = A == 1 ? B : Math.min(A, B);

        // Binary search for the maximum possible square side length
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate the total number of pieces of length 'mid' that can be cut from A and B
            int pieces = (A / mid) + (B / mid);

            // If we can make at least 4 pieces of length 'mid', try for a larger side
            if (pieces >= 4) {
                left = mid + 1; // Search for a larger square side
            } else {
                right = mid - 1; // Search for a smaller square side
            }
        }

        // The largest possible square side length found is `right`
        return right;
    }

}
