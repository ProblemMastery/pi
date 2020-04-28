package Heap;

import java.util.*;

public class TopKFrequentElements {


    /**
     * Time O(NLogK) : Space : O(N) due to Map
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        // find the frequency of each number

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>
                ((e1, e2) -> e1.getValue() - e2.getValue());

        // keep adding entries, so when higher frequency value number is entered, the root is polled
        // means the entry with lesser frequncies when size is greater than k

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<Integer> topKNumbers = new ArrayList<>();
        while (!minHeap.isEmpty())
            topKNumbers.add(0,minHeap.poll().getKey()); // most frequent appears first

        return topKNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = findTopKFrequentNumbers(new int[] { 5, 3,12, 11, 3, 11, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
