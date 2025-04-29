package pattern.bfsTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class TreeBFS {
    // BFS traversal of the tree
    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // list to store levels

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                currentLevel.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

            }

            result.add(currentLevel);
        }


        return result;
    }

    // Utility function to print the BFS result
    public static void printBFS(List<List<Integer>> levels) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < levels.size(); i++) {
            for (int item : levels.get(i)) {
                result.add(item);
            }
        }

        int start = 0;
        int end = result.size() - 1;

//        while (start < end) {
//            int temp = result.get(start);
//            result.set(start, result.get(end));
//            result.set(end, temp);
//            start++;
//            end--;
//        }

        for (int item : result) {
            System.out.print(item + " ");
        }

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add children to the queue
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            // Add the level at the beginning of the result list
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Perform BFS
        List<List<Integer>> levels = levelOrderBottom(root);

        // Print the result
        printBFS(levels);
    }
}
