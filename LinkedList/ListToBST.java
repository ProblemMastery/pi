package LinkedList;

import com.sun.source.tree.Tree;

public class ListToBST {

    /*Given a singly linked list where elements are sorted in ascending order,
    convert it to a height balanced BST.
    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
    the two subtrees of every node never differ by more than 1.

     */
    /**
     * Soln : First we need to transform list to array why ? to get the values with given index.
     * we can optimize it by just getting the size of the list and iterate on the list with head pointer.
     * Then we use binary search method to find the middle element
     */
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getListSize(head);
        this.head = head;
       return helper( 0, size-1);
    }

    private TreeNode helper(int start, int end) {

        int mid = start + (end-start)/2;
        TreeNode left = helper(start, mid-1);
        TreeNode node = new TreeNode(mid);
        node.left = left;
        this.head = head.next;
        node.right = helper(mid+1, end);
        return node;
    }

    private int getListSize(ListNode head) {
        ListNode ptr = head;
        int size = 0;
        while (ptr != null) {
            ptr = ptr.next;
            size++;
        }
        return size;
    }
    }
