package Graph.DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    /*
    Given a binary tree and a number ‘S’,
    find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

     Soln : O(N∗logN).Space and time.

     Similar problems : Problem 1: Given a binary tree, return all root-to-leaf paths.

Solution: We can follow a similar approach. We just need to remove the “check for the path sum”.

Problem 2: Given a binary tree, find the root-to-leaf path with the maximum sum.

Solution: We need to find the path with the maximum sum. As we traverse all paths, we can keep track of the path with the maximum sum.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {

        List<List<Integer>> allPaths = new ArrayList<>();
        findPathsRecursive(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, int sum, ArrayList<Integer> currentPath,
                                           List<List<Integer>> allPaths) {

        if (root == null)
            return;
        // add the current node to the path
        currentPath.add(root.val);
        // if the current node is a leaf and its value is equal to sum, save the current path
        if (root.left == null && root.right == null && root.val == sum) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        findPathsRecursive(root.left, sum - root.val, currentPath, allPaths);
        findPathsRecursive(root.right, sum - root.val, currentPath, allPaths);
        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }


}
