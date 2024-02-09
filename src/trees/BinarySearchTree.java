package trees;

public class BinarySearchTree {
    TreeNode root;

    public void insert(int value) {
        insert(this.root, value);
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode();
            root.data = value;
        } else if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void preOrderTraversal() {
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            preOrderTraversal(root.left);
            System.out.print(root.data + "  ");
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.print(root.data + "  ");
        }
    }


}
