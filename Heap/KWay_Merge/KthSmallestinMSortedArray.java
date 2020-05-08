package Heap.KWay_Merge;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestinMSortedArray {

    private static class Node {
        int arrayIndex;
        int elementIndex;
        public Node(int arrayIndex, int elementIndex ) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex]
                - lists.get(n2.arrayIndex)[n2.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Node(i, 0));
        }

        int numberCount = 0 ;
        int result = 0 ;
        while (!minHeap.isEmpty()){

            Node e = minHeap.poll();
            result =  lists.get(e.arrayIndex)[e.elementIndex];

            numberCount++;
            if (numberCount == k ){
                break;
            }

            e.elementIndex++;
            if ( lists.get(e.arrayIndex).length > e.elementIndex)
                minHeap.add(e);
        }
        return result;
    }
}
