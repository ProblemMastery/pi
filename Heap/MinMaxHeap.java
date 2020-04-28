package Heap;

import java.util.*;
import java.util.stream.Collectors;

public class MinMaxHeap {


    public static List<Integer> maxHeap(List<Integer> input, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        Iterator<Integer> itr = input.iterator();

        for ( int i = 0 ; i < input.size(); i ++ ){
            if (itr.hasNext())
                pq.add(itr.next());
        }

        while (k > 0 ){
            pq.poll();
            k--;
        }

        return pq.stream().collect(Collectors.toList());

    }
    public static List<Integer> minHeap(List<Integer> input, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Iterator<Integer> itr = input.iterator();

        for ( int i = 0 ; i < input.size(); i ++ ){
            if (itr.hasNext())
                    pq.add(itr.next());
        }

        while (k > 0 ){
            pq.poll();
            k--;
        }

        return pq.stream().collect(Collectors.toList());

    }
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(30);
        l1.add(10);
        l1.add(20);
        l1.add(1);
        l1.add(2);
        l1.add(5);
        l1.add(8);

       // List<Integer> maxKElements = minHeap(l1, 2);
        //System.out.print(maxKElements.toString());

        List<Integer> minKElements = maxHeap(l1, 2);
        System.out.print(minKElements.toString());
    }

}
