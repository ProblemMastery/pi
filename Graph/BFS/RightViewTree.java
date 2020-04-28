package Graph.BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightViewTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return null;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()) {

            int levelSize = queue.size();
            TreeNode rightViewNode = null;

            for (int i= 0 ; i <levelSize ; i++){

                TreeNode currentNode = queue.pollFirst();
                rightViewNode = currentNode;

                if (currentNode.left != null)
                    queue.addLast(currentNode.left);
                if (currentNode.right != null)
                    queue.addLast(currentNode.right);
            }

            result.add(rightViewNode.val);

        }

        return result;
    }




}
