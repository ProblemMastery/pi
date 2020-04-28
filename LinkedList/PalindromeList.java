package LinkedList;

import java.util.List;

public class PalindromeList {
    /*
    Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

    Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
    Output: true

    Soln : Slow and fast pointer.
     */

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode mid = getMiddle(head);
        ListNode secondHalfHead = reverseList(mid);
        ListNode copyHead = secondHalfHead;

        while (head != null && secondHalfHead != null ){

            if (head.val != secondHalfHead.val)
                 break;

            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }

        reverseList(copyHead);

        if (head == null && secondHalfHead == null)
            return true;

        return false;

        }

    private static ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverseList(ListNode head){

        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " +isPalindrome(head));

       head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
