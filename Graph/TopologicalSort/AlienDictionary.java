package Graph.TopologicalSort;

import java.util.*;

public class AlienDictionary {
    /**
     * Problem Statement #
     * There is a dictionary containing words from an alien language for which we don’t know the
     * ordering of the characters.
     * Write a method to find the correct order of characters in the alien language.
     *
     * Input: Words: ["ba", "bc", "ac", "cab"]
     * Output: bac
     * Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
     * Output: ywxz
     * Input: Words: ["cab", "aaa", "aab"]
     * Output: cab
     */

    public static String findOrder(String[] words) {
        List<Character> sortedList = new ArrayList<>();

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegreeMap = new HashMap<>();
        Queue<Character> sourceQueue = new LinkedList<>();

        // a. Initialize the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegreeMap.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        // b. Build the graph
        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i], w2 = words[i + 1]; // compare the adjacent words
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {  // if the two characters are different
                    graph.get(parent).add(child);
                    inDegreeMap.put(child, inDegreeMap.get(child) + 1);
                    // only the first different character between the two words will help us find the order
                    break;
                }
            }
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        for (char source : inDegreeMap.keySet()) {
            if (inDegreeMap.get(source) == 0)
                sourceQueue.add(source);
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while (! sourceQueue.isEmpty()) {

            char source = sourceQueue.poll();
            sortedOrder.append(source);
            List<Character> children = graph.get(source);
            for (char child : children) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                if (inDegreeMap.get(child) <= 0)
                    sourceQueue.add(child);
            }
        }
        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore, we
        // will not be able to find the correct ordering of the characters
        if (sortedOrder.length() != inDegreeMap.size())
            return "";

        return sortedOrder.toString();
    }
}
