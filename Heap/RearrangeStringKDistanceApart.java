package Heap;

import java.util.*;

public class RearrangeStringKDistanceApart {
/**
 * Rearrange String K Distance Apart (hard) #
 * Given a string and a number ‘K’,
 * find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
 *
 * Example 1:
 *
 * Input: "mmpp", K=2
 * Output: "mpmp" or "pmpm"
 * Explanation: All same characters are 2 distance apart.
 * Example 2:
 *
 * Input: "Programming", K=3
 * Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
 * Explanation: All same characters are 3 distance apart.
 */


    public static String reorganizeString(String str, int k) {

        Map<Character,Integer> numCharFrequencyMap = new HashMap<>();

        for (char c : str.toCharArray())
            numCharFrequencyMap.put(c, numCharFrequencyMap.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        // add all of them to heap
        maxHeap.addAll(numCharFrequencyMap.entrySet());

        // result String
        StringBuilder result = new StringBuilder(str.length());

        // Queue to keep track last k entries
        Queue<Map.Entry<Character, Integer>> queue  = new LinkedList<>();

        while (!maxHeap.isEmpty()){

            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            result.append(currentEntry.getKey());
            // decrement the frequency and add it to the Map in the next iteration
            currentEntry.setValue(currentEntry.getValue()-1);
            queue.offer(currentEntry);
            // when queue size is greater than k, now its time to add the first entry in the queue back to heap
            // we are sure that the first entry is always k distance from its next entry, as there are K chars in queue.
            if (queue.size() == k ){
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue()>0)
                    maxHeap.add(entry);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
    }
}
