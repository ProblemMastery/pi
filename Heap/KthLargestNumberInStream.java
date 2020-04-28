package Heap;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {
/**
 * Design a class to efficiently find the Kth largest element in a stream of numbers.
 *
 * The class should have the following two things:
 *
 * The constructor of the class should accept an integer array containing initial numbers
 * from the stream and an integer ‘K’.
 * The class should expose a function add(int num) which will store the given number and
 * return the Kth largest number.
 *
 * Time : O(logK) : space = O(K)
 */

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.minHeap = new PriorityQueue<>((n1, n2)-> n1 - n2);
        this.k = k;
        for (int n : nums){
            minHeap.add(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }
    }

    public int add(int num) {
        int root = minHeap.peek();
        if ( num > root){
            minHeap.add(num);
            if (minHeap.size() > this.k) {
                minHeap.poll();
                return minHeap.peek();
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
