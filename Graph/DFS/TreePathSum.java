package Graph.DFS;

public class TreePathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPath(TreeNode root, int sum) {

         return helper (root, sum);

    }

    private static boolean helper(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (root.val == sum && root.left == null && root.right == null)
            return true;

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }
}
