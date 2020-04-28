package Graph.DFS;

public class PathWithGivenSequence {

    /*
Given a binary tree and a number sequence,
find if the sequence is present as a root-to-leaf path in the given tree.
    Sequence: [1, 9, 9]Output: true Explaination: The tree has a path 1 -> 9 -> 9.

     */

    public static boolean findPath(AllPaths.TreeNode root, int[] sequence) {
        return helper (root, sequence, 0);
    }

    private static boolean helper(AllPaths.TreeNode root, int[] sequence, int index) {

        if (root == null)
            return false;

        if (index >= sequence.length)
            return  false;

        if( root.val != sequence[index] )
            return false;

        if (root.left == null && root.right == null && index == sequence.length )
            return true;

        return helper(root.left, sequence, index+1)||helper(root.right, sequence, index+1);

    }


}
