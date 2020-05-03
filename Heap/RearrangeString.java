package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    /**
     * Problem Statement #
     * Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
     *
     * Example 1:
     *
     * Input: "aappp"
     * Output: "papap"
     * Explanation: In "papap", none of the repeating characters come next to each other.
     * Example 2:
     *
     * Input: "Programming"
     * Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
     * Explanation: None of the repeating characters come next to each other.
     */


    public static String rearrangeString(String str) {

        // create a map of chars and frequency
        Map<Character,Integer> numCharFrequencyMap = new HashMap<>();

        for (char c : str.toCharArray())
         numCharFrequencyMap.put(c, numCharFrequencyMap.getOrDefault(c,0)+1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (e1, e2) -> e2.getValue() - e1.getValue());
        // add all of them to heap
        maxHeap.addAll(numCharFrequencyMap.entrySet());

        // result String
        StringBuilder result = new StringBuilder(str.length());

        /**
         * we should first append the most frequent characters to the output strings,
         * for which we can use a Max Heap
         *
         * So in each step, we should append one occurrence of the highest frequency character to the output string.
         * We will not put this character back in the heap to ensure that no two same characters are adjacent to each other.
         *
         *  In the next step, we should process the next most frequent character from the heap in the same way and then,
         *  at the end of this step, insert the character from the previous step back to the heap after decrementing its frequency.
         *  that is why we need "previousEntry"
         */
        Map.Entry<Character, Integer> previousEntry = null;
        while ( !maxHeap.isEmpty()){

            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            //add the previous entry to heap if its value is not 0;
            if (previousEntry != null && previousEntry.getValue() > 0)
                maxHeap.offer(previousEntry);

            result.append(currentEntry.getKey());
            // decrement the frequency and add it to the Map in the next iteration
            currentEntry.setValue(currentEntry.getValue()-1);

            // set current to previous before moving to next iteration
            previousEntry = currentEntry;
        }

        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }

    }
