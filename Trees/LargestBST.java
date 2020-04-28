package Trees;

public class LargestBST {

    int largestSize = 0;

    class Result {
        boolean isBST;
        int size;
        int min;
        int max;

        Result(boolean b, int size, int m, int x) {
            this.isBST = b;
            this.size = size;
            this.min = m;
            this.max = x;
        }
    }

    public int largestBSTSubtree(TreeNode root) {

        return helper(root).size;
    }

    private Result helper(TreeNode node) {

        Result leftResult = node.left != null ? helper(node.left) : new Result(true, 0, node.key, node.key);
        Result rightResult = node.right != null ? helper(node.right) : new Result(true, 0, node.key, node.key);

        boolean isCurrentBST = false;
        if (node.key >= leftResult.max && node.key <= rightResult.min)
            isCurrentBST = true;

        boolean isBST = leftResult.isBST && rightResult.isBST && isCurrentBST;
        int size = leftResult.size + rightResult.size + 1;
        Result nodeResult = new Result(isBST, size, isBST ? leftResult.min : Integer.MAX_VALUE,
                isBST ? rightResult.max : Integer.MIN_VALUE);
        return nodeResult;
    }
}
