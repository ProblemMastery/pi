package Heap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
10.3 : given a long  sequence where each number is atmost k away from its correctly sorted position.
sort it :
Algorithm : maintain a minheap of k elements, when you add the next element, extract min.
keep doing this till array is empty.
 */
public class KSortedArray {

    public static List<Integer> sortKSorted(List<Integer> input, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Iterator<Integer> itr = input.iterator();
        for(int i =0 ; i < k && itr.hasNext(); i++){
            minHeap.add(itr.next());
        }
        List<Integer> result = new LinkedList<>();
        while(itr.hasNext()){
            minHeap.add(itr.next());
            result.add(minHeap.poll());
        }
        result.addAll(Stream.generate(minHeap::remove).limit(minHeap.size()).collect(Collectors.toList()));
        return  result;
    }
    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        int [] l = {3,-1,2,6,4,5,8};
        l1.add(3);
        l1.add(-1);
        l1.add(2);
        l1.add(6);
        l1.add(4);
        l1.add(5);
        l1.add(8);

        List<Integer> res = sortKSorted(l1, 2);

        System.out.print(res.toString());
    }
}
