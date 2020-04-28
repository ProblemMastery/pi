package LinkedList;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode x =  helper(head, null);
        return x;

    }

    private static ListNode helper(ListNode current, ListNode prev){

        if( current.next == null ){
            current.next = prev;
            return current;
        }
        ListNode head = helper(current.next, current);
        current.next = prev;
        return head;
    }
    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();
        for (int i = 0; i < 5; i++) {
            l1.insert(i);
        }
        System.out.print(l1);
        reverseList(l1.head.next);
        System.out.println(l1);
    }
}
