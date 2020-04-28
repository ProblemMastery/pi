package Graph.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;

        while (!queue.isEmpty()) {
            minDepth++;
            TreeNode currentNode = queue.pollFirst();

            if (currentNode.left == null && currentNode.right == null) // leaf node
                return minDepth;

            if (currentNode.left != null)
                queue.addLast(currentNode.left);
            if (currentNode.right != null)
                queue.addLast(currentNode.right);

        }
        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
