package Trees;

public class Symmetry {
/*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

              1
             /  \
            2    2
           / \  / \
          3  4 4  3


    But the following [1,2,2,null,3,null,3] is not:

             1
            / \
            2   2
            \    \
            3     3

 */

    public boolean isSymmetry(TreeNode root){
        if(root == null){
            return true;
        }
       return  isSymmetry(root, root);
    }

    public boolean isSymmetry(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return (t1.left.key == t2.right. key) && isSymmetry(t1.left , t2.right)
                && isSymmetry(t1.right , t2.left);
    }
}

