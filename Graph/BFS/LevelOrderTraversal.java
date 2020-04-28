package Graph.BFS;

import java.util.*;


public class LevelOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

        public static List<List<Integer>> traverse(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (root == null)
                return result;

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (! queue.isEmpty()){

                int levelSize = queue.size();
                System.out.println("level size is "+levelSize);
                List<Integer> levelList = new ArrayList<>();
                for (int i= 0 ; i <levelSize ; i++){

                    TreeNode currentNode = queue.pollFirst();
                    System.out.println("currentNode is "+ currentNode.val);
                    if (currentNode.left != null)
                        queue.addLast(currentNode.left);
                    if (currentNode.right != null)
                        queue.addLast(currentNode.right);
                    levelList.add(currentNode.val);
                }
                result.add(levelList);
            }

            return result;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(9);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            List<List<Integer>> result = LevelOrderTraversal.traverse(root);
            System.out.println("Level order traversal: " + result);
        }
    }


