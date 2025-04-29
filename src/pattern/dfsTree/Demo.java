package pattern.dfsTree;

import com.sun.source.tree.*;

import java.util.*;

public class Demo {

    public static void preOrderTraversal(TreeNode root) {
        // root -> left -> right

        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            System.out.print(current.val + " ");

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    public static void inOrdertraveral(TreeNode root) {
        // left -> root -> right;
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");

            current = current.right;

        }
    }


    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            stack2.push(current);

            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    public static void main(String[] args) {
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
