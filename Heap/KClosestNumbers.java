package Heap;

import java.util.*;

public class KClosestNumbers {

    /**
     * Problem Statement #
     * Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
     *
     * Example 1:
     *
     * Input: [5, 6, 7, 8, 9], K = 3, X = 7
     * Output: [6, 7, 8]
     * Example 2:
     *
     * Input: [2, 4, 5, 6, 9], K = 3, X = 6
     * Output: [4, 5, 6]
     */

    private static class Entry{
        int key;
        int value;
        public Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {

        List<Integer> result = new ArrayList<>();

        int closestNumberIndex = Arrays.binarySearch(arr, X);

        //now get all the numbers that are K distant from the closestNumberIndex

        int low = closestNumberIndex-K;
        low = Math.min(low, 0); // low cannot be less than 0;

        int high = closestNumberIndex+K;
        high = Math.max(high, arr.length-1);

        PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1,n2)-> n1.key - n2.key);
        // we need the top 'K' elements having smallest difference from 'X'
        for (int i = low ; i < high; i++){
            Entry e = new Entry(Math.abs(arr[i] - X), i);
            minHeap.add(e);
        }
        for (int i = 0 ; i < K ; i++){
            result.add(arr[minHeap.poll().value]);
        }

        Collections.sort(result);
        return result;

    }
}
