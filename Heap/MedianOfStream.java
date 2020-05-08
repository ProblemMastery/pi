package Heap;

import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfStream(){
        minHeap = new PriorityQueue<>((n1, n2)-> n1-n2);
        maxHeap = new PriorityQueue<>((n1, n2)-> n2-n1);
    }

    public void insertNum(int num){
        // max heap stores smaller numbers,
        // so if an incoming number is smaller than the smallest so far then add to maxheap
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else  // else it belongs to minheap
            minHeap.add(num);

        // we always want maxHEap to have more numbers
        if (maxHeap.size() > minHeap.size()+1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian(){
        // if the count is equal in both heaps then its even count
        if (maxHeap.size() == minHeap.size())
            return (minHeap.peek() + maxHeap.peek())/2.0;

        // else the the middle or median element will be in maxHeap
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(3);
        medianOfStream.insertNum(1);
        System.out.println("The median is: " + medianOfStream.findMedian());
        medianOfStream.insertNum(5);
        System.out.println("The median is: " + medianOfStream.findMedian());
        medianOfStream.insertNum(4);
        System.out.println("The median is: " + medianOfStream.findMedian());
    }
}
