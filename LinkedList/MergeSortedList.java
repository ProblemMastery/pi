package LinkedList;

public class MergeSortedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion

    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        else if (l1.val < l2.val){
            l1.next = mergeTwoSortedList(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoSortedList(l1, l2.next);
            return l2;
        }
    }

    //Iteration
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;

        while(l1 != null && l2 != null){

            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = l1!= null ? l1 : l2;
        return dummyHead;
    }
}
