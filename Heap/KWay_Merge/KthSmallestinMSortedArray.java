package Heap.KWay_Merge;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestinMSortedArray {

    private static class Element {
        int arrayIndex;
        int elementIndex;
        public Element(int arrayIndex, int elementIndex ) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {

        PriorityQueue<Element> minHeap = new PriorityQueue<>((e1, e2) -> lists.get(e1.arrayIndex)[e1.elementIndex]
                - lists.get(e2.arrayIndex)[e2.elementIndex]);

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new Element(i, 0));
        }

        int numberCount = 0 ;
        int result = 0 ;
        while (!minHeap.isEmpty()){

            Element e = minHeap.poll();
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
