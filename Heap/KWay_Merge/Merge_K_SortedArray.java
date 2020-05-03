package Heap.KWay_Merge;

import java.util.PriorityQueue;

public class Merge_K_SortedArray {
    /**
     * Problem Statement #
     * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
     *
     * Example 1:
     *
     * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
     * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
     * Example 2:
     *
     * Input: L1=[5, 8, 9], L2=[1, 7]
     * Output: [1, 5, 7, 8, 9]
     */

    /**
     * Time =  O(N∗logK), Space - O(K)
     */

    private static class ListNode {
        int value;
        ListNode next ;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode merge(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((e1,e2)-> e1.value - e2.value);

        for (ListNode root : lists)
            minHeap.add(root);

        ListNode resultHead = null, resultCurrentPointer= null;

        while (!minHeap.isEmpty()){
            // polling the smallest, initially this is smallest root.
            ListNode node = minHeap.poll();
            if( resultHead == null) {
                resultHead = resultCurrentPointer = node;
            }else {
                resultCurrentPointer.next = node;
                resultCurrentPointer = resultCurrentPointer.next;
            }
            if (node.next != null)
                minHeap.add(node.next);
        }

       return resultHead;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        ListNode current = l1.next;
        for (int i = 7; i < 15; i+=2) {
            current.next = new ListNode(i);
            current = current.next;
        }
        ListNode temp = l1;
        System.out.println( "first List is  ");
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(8);
         temp = l2;
        System.out.println( "\n second List is  ");
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }


            ListNode l3 = new ListNode(0);
        l3.next = new ListNode(1);

        temp = l3;
        System.out.println( "\n Third List is  ");
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        ListNode result = merge(new ListNode[]{l1, l2, l3});
        System.out.println("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
