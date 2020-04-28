package Heap;

import java.util.*;

public class FrequencySortChars {
    /**
     * Given a string, sort it based on the decreasing frequency of its characters.
     *
     * Example 1:
     *
     * Input: "Programming"
     * Output: "rrggmmPiano"
     * Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
     */



    public static String sortCharacterByFrequency(String str) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1, e2)->e2.getValue() - e1.getValue());

        for (char c : str.toCharArray())
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0)+1);

        for(Map.Entry<Character,Integer> entry : charFrequencyMap.entrySet()){
            maxHeap.add(entry);
        }

       StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()){
            char c = maxHeap.poll().getKey();
            int f = charFrequencyMap.get(c);
            while (f >0) {
                result.append(c);
                f--;
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String result = sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

    }
}
