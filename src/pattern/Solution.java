package pattern;

import java.util.*;

public class Solution {

    public int solution(int[] A, int[] B) {
        int n = A.length;
        int maxPerShop = n / 2; // Maximum candies we can buy from each shop

        // Use hash sets to store unique candy types
        HashSet<Integer> shopA = new HashSet<>();
        HashSet<Integer> shopB = new HashSet<>();

        // Add candy types to their respective sets
        for (int candy : A) {
            shopA.add(candy);
        }
        for (int candy : B) {
            shopB.add(candy);
        }

        // Merge the two sets into a distinct candy types set
        HashSet<Integer> allCandies = new HashSet<>(shopA);
        allCandies.addAll(shopB);

        // Calculate the maximum number of distinct candies we can buy
        int totalDistinct = allCandies.size();
        int remainingSpace = maxPerShop + maxPerShop;

        // Return the smaller of total distinct candies or maximum possible candies
        return Math.min(totalDistinct, remainingSpace);


    }

    // output  of above alogrithm was 5 instead of 4 write a more accurate algorithm
    public int solution2(int[] A, int[] B) {
        int n = A.length;
        int maxPerShop = n / 2; // Maximum candies we can buy from each shop

        // Use hash sets to store unique candy types
        HashSet<Integer> shopA = new HashSet<>();
        HashSet<Integer> shopB = new HashSet<>();

        // Add candy types to their respective sets
        for (int candy : A) {
            shopA.add(candy);
        }
        for (int candy : B) {
            shopB.add(candy);
        }

        // Merge the two sets into a distinct candy types set
        HashSet<Integer> allCandies = new HashSet<>(shopA);
        allCandies.addAll(shopB);

        // Calculate the maximum number of distinct candies we can buy
        int totalDistinct = allCandies.size();
        int remainingSpace = maxPerShop + maxPerShop;

        // Return the smaller of total distinct candies or maximum possible candies
        return Math.min(totalDistinct, remainingSpace);
    }

    public int solution3(int[] A, int[] B) {
        int n = A.length;
        int maxPerShop = n / 2; // Maximum candies we can buy from each shop

        // Use hash sets to store unique candy types
        HashSet<Integer> shopA = new HashSet<>();
        HashSet<Integer> shopB = new HashSet<>();

        // Add candy types to their respective sets
        for (int candy : A) {
            shopA.add(candy);
        }
        for (int candy : B) {
            shopB.add(candy);
        }

        // Result set to track all purchased candies
        HashSet<Integer> purchased = new HashSet<>();

        // Buy candies from Shop A
        int shopACount = 0;
        for (int candy : shopA) {
            if (shopACount < maxPerShop) {
                purchased.add(candy);
                shopACount++;
            }
        }

        // Buy candies from Shop B
        int shopBCount = 0;
        for (int candy : shopB) {
            if (shopBCount < maxPerShop && !purchased.contains(candy)) {
                purchased.add(candy);
                shopBCount++;
            }
        }

        // The size of the purchased set is the maximum distinct candies
        return purchased.size();
    }

    public static void main(String[] args) {
//        int[] A = {3, 1, 2, 3};
//        int[] B = {3, 2, 1, 4};

        int[] A = {1, 2, 3, 4};
        int[] B = {3, 3, 3, 7};

//        int[] A = {2, 2, 2, 2, 2, 2};
//        int[] B = {7, 4, 2, 5, 1, 2}; // expected output 4

        Solution solution = new Solution();
        System.out.println(solution.solution3(A, B));
    }
}
