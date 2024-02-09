package trees;

public class TreeAlgorithms {
    public static void main(String[] args) {

        //          5
        //       2        4
        //    9    10  7

        TreeNode rootNode = new TreeNode();
        rootNode.data = 5;
        TreeNode nodeTwo = new TreeNode();
        nodeTwo.data = 2;
        TreeNode nodeFour = new TreeNode();
        nodeFour.data = 4;
        TreeNode nodeNine = new TreeNode();
        nodeNine.data = 9;
        TreeNode nodeTen = new TreeNode();
        nodeTen.data = 10;
        TreeNode nodeSeven = new TreeNode();
        nodeSeven.data = 7;

        rootNode.left = nodeTwo;
        rootNode.right = nodeFour;
        nodeTwo.left = nodeNine;
        nodeTwo.right = nodeTen;
        nodeFour.left = nodeSeven;

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = rootNode;

//        TreeNode rootNode = new TreeNode();
//        rootNode.data = 2;
//
//        BinarySearchTree tree = new BinarySearchTree();
//
//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(3);
//        tree.insert(4);

        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
        System.out.println();
        tree.inOrderTraversal();


    }
}
