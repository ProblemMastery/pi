package Trees;

import LinkedList.DoublyLinkedList;

/*
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
426. Convert Binary Search Tree to Sorted Doubly Linked List

Solution : https://www.youtube.com/watch?v=FsxTX7-yhOw
 */
public class BSTtoList {

    TreeNode head = null;
    TreeNode prev = null;

    //recursion
    public TreeNode convertBSTToDoublyLinkedList(TreeNode root){

        if(root == null){
            return null;
        }
            helper(root);
            prev.right = head;
            head.left = prev;
            return head;
    }
    // like inorder traversal it has 3 steps
    // visit left node
    // process node
    // visit right node
    private void helper(TreeNode currentNode) {

        if(currentNode == null){
            return;
        }
        // process left subtree
        helper(currentNode.left);

        //process current node
        if(prev == null){
            head = currentNode;
        }else {

            currentNode.left = prev;
            prev.right = currentNode;
        }
        //make currentNode as previous
        prev =  currentNode;

        // process rightNode
        helper(currentNode.right);
    }


}
