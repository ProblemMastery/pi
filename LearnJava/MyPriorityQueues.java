package LearnJava;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueues {

    Queue<String> pQueue = new PriorityQueue<String>();
    static Queue<Integer> minHeap = new PriorityQueue<>(5,
            (s1, s2)-> Integer.compare(s1,s2));
    static Queue<Integer> maxHeap = new PriorityQueue<>(5,
            (s1, s2)-> Integer.compare(s2,s1));

    public static void playPQ(int k){

        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        maxHeap.add(45);
        maxHeap.poll(); // removes 45
        Iterator itr = maxHeap.iterator();


        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println("MinHeap");
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(15);
        minHeap.poll(); // removes 15
        Iterator minHeapIterator = minHeap.iterator();

        while (minHeapIterator.hasNext())
            System.out.println(minHeapIterator.next());




    }
    public static void main(String[] args) {

        playPQ(4);
    }
}
