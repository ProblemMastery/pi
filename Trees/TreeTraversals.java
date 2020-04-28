package Trees;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeTraversals {

    /*
    In order
     */

    //recursion
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + "\t");
            inorder(root.right);
        }
    }

    public void postOrder(TreeNode node){

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key);
    }

    public void preOrder(TreeNode node){
        if (node == null)
            return;
        System.out.print(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    //Iterative
    /*
    Inorder : we cant rely on recusion for their stack, so we need to make use stack programmatically

        we keep adding the nodes on the left and process them
     */

    public List<TreeNode> iterativeInorder(TreeNode root){
        if( root == null){
            return Collections.EMPTY_LIST;
        }
        List<TreeNode> inorderTraversal = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }else {
                if(stack.isEmpty()){
                    break;
                }else {
                    node = stack.pollFirst();
                    //process the node
                    inorderTraversal.add(node);
                    node = node.right;
                }
            }
        }
        return inorderTraversal;
    }
    /*
    Preorder : root, left, right,
    we will use stack
    so we process the node, then add right then left, pop stack, we ll get left.
    keep iterating until stack is empty
     */

    public List<TreeNode> iterativePreOrder(TreeNode root)
    {
        if( root == null){
            return Collections.EMPTY_LIST;
        }
        List<TreeNode> preOrderTraversal = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        stack.addFirst(root);
        while(!stack.isEmpty()){
            node = stack.pollFirst();
            preOrderTraversal.add(node);
            if(node.right!= null)
                stack.addFirst(node.right);
            if(node.left != null)
                stack.addFirst(node.left);
        }
        return preOrderTraversal;
    }





}
