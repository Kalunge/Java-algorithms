package pattern;

import java.util.*;

public class MainDemo {

    public static int removeDuplicates(int[] arr){
        return 0;
    }

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


    public static void preOrderTraversal(TreeNode root){

    }

    public static void inOrdertraveral(TreeNode root){

    }

    public static void postOrderTraversal(TreeNode root){

    }
    public static void main(String[] args) {
//        int[] A = {3, 1, 2, 3};
//        int[] B = {3, 2, 1, 4};

//        int[] A = {1, 2, 3, 4};
//        int[] B = {3, 3, 3, 7};

        int[] A = {2, 2, 2, 2, 2, 2};
        int[] B = {7, 4, 2, 5, 1, 2};
        MainDemo mainDemo = new MainDemo();
        System.out.println(mainDemo.solution(A, B));


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Preorder Traversal:");
        preOrderTraversal(root); // Output: 1 2 4 5 3

        System.out.println("\nInorder Traversal:");
        inOrdertraveral(root); // Output: 4 2 5 1 3

        System.out.println("\nPostorder Traversal:");
        postOrderTraversal(root); // Output: 4 5 2 3 1
    }


}


class TreeNode{
    int data;

    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}