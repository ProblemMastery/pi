package Heap;

import java.util.*;

public class MergeSortedArrays {

    /*
    Given a couple of sorted arrays, merge them in sorted order.
    brute force is merge them and sort, but we are not taking use of the sorted property.
    E.g. <3,5,7> , <0,6> , <0,6,20> => <0,0,3,5,6,6,20>
    Algorithm : use min heap, take first element in each array form minheap, remove the smallest, then take
    the item from the array that was removed in the heap.
    keep doing this until minheap is empty.
     */

    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays ) {

        List<Iterator<Integer>> iteratorList = new ArrayList<>(sortedArrays.size());
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry n1, ArrayEntry n2)     {
                return Integer.compare(n1.val, n2.val);
            }
        });

        //populate iterator list with sortArrays iterator
        for (List<Integer> array : sortedArrays) {
            iteratorList.add(array.iterator());
        }

        //populate minheap with first values of each array
        for (int i = 0; i < iteratorList.size(); i++) {
            minHeap.add(new ArrayEntry(iteratorList.get(i).next(), i));
        }

        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            ArrayEntry entry = minHeap.poll(); // get the min value from heap
            result.add(entry.val); // add it to the result
            int listId = entry.arrayId; // get the array id
            if(iteratorList.get(listId).hasNext())  //find if the array has next element
                minHeap.add(new ArrayEntry(iteratorList.get(listId).next(), listId));
        }
        return result;
    }

        // since we need to maintain arrayid with its value
        private static class ArrayEntry{
            int val;
            int arrayId;

            public ArrayEntry(Integer value, Integer arrayId) {
                this.val = value;
                this.arrayId = arrayId;
            }
        }
    public static void main(String[] args){

        List<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(5);
        l1.add(7);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(6);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(6);
        l3.add(20);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        List<Integer> result = mergeSortedArrays(lists);
        result.stream().forEach(c->System.out.print(" "+c));
    }

}
