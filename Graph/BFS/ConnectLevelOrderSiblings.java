package Graph.BFS;

import java.util.Deque;
import java.util.LinkedList;

public class ConnectLevelOrderSiblings {

    private static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;
        TreeNode levelNext;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void connect(TreeNode root) {

        if (root == null)
            return;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            TreeNode prev = null;
            for (int i = 0; i <  levelSize; i++) {
                TreeNode currentNode = queue.pollFirst();
                if (prev.levelNext != null)
                    prev.levelNext = currentNode;
                prev = currentNode;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }



}
