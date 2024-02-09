package trees;

public class TreeAnswer {
    // Java code​​​​​​‌​‌​‌​‌‌‌​​‌​‌‌​​‌​‌​​‌‌‌ below
// Write your answer here, and then test your code.
// Your job is to implement the findHeight() method.

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Return the maximum depth of the binary tree
    static int findHeight(TreeNode root) {
        // Your code goes here.
        if (root == null) {
            return 0;
        } else {
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }

    }

}

