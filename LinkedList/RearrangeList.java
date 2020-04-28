package LinkedList;

public class RearrangeList {


    public static void reorder(ListNode head) {

        ListNode mid = getMiddle(head);
        ListNode secondHalf = reverseList(mid);

        while (head != null && secondHalf != null){

            ListNode temp = head.next;
            head.next = secondHalf;
            head = temp;

            temp = secondHalf.next;
            secondHalf.next = head;
            secondHalf = temp;
        }

        if (head != null)
            head.next = null;
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
}
