package Graph.DFS;

public class Tree_Diameter {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int TreeDiameter = 0;

    public static int findDiameter(TreeNode root) {

        return calculateHeight(root);
    }

    private static int calculateHeight(TreeNode root) {

        if ( root == null)
            return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        int diameter = leftHeight+rightHeight+1;

        TreeDiameter = Math.max(diameter, TreeDiameter);

        return Math.max(leftHeight, rightHeight)+1;

    }
}
