package Heap.KWay_Merge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Hard_SmallestRange {
    /**
     * Problem Statement #
     * Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
     *
     * Example 1:
     *
     * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
     * Output: [4, 7]
     * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
     */

    private static class Node {
        int arrayIndex;
        int elementIndex;
        public Node(int arrayIndex, int elementIndex ){
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int[] findSmallestRange(List<Integer[]> lists) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) ->
                lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;

        // iterate on lists to get first item from each list and add them to MinHeap
        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(i, 0));
            currentMax = Math.max(currentMax, lists.get(i)[0]);
        }
        System.out.println ("CurrentMax is "+currentMax);
        // now that first elements are added, check the range each time;
        //idea is to get one number from each list, and smallest range.

        // minHeap always has one element from each list
        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();

            int currRange  = currentMax - lists.get(node.arrayIndex)[node.elementIndex];
            if (currRange < rangeEnd - rangeStart ) {
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMax;
            }

            // now that the smallest element(node) from the heap is polled, get the next element from teh same list
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node);
                // update the currentMax
                currentMax = Math.max(currentMax, lists.get(node.arrayIndex)[node.elementIndex]);
            }
            System.out.println("heap now is ");
            debugHeap(minHeap, lists);

        }
        return new int[]{rangeStart, rangeEnd};
    }

    private static void debugHeap(PriorityQueue pq, List<Integer[]> lists){

        Iterator<Node> it = pq.iterator();
        while (it.hasNext()){
            Node node = it.next();
            System.out.print(lists.get(node.arrayIndex)[node.elementIndex]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }


}
