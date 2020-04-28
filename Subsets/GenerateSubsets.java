package Subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateSubsets {
    /**
     * Given a set with distinct elements, find all of its distinct subsets.
     * Input: [1, 3]
     * Output: [], [1], [3], [1,3]
     *
     * Input: [1, 5, 3]
     * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
     *
     * To generate all subsets of the given set, we can use the Breadth First Search (BFS) approach. We can start with an empty set, iterate through all numbers one-by-one, and add them to existing sets to create new subsets.
     *
     * Let’s take the example-2 mentioned above to go through each step of our algorithm:
     *
     * Given set: [1, 5, 3]
     *
     * Start with an empty set: [[]]
     * Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
     * Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
     * Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].
     * time & space : - O(2^N)
     * ​​ )
     */

    public static List<List<Integer>> findSubsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int n : nums){
            int N = subsets.size();
            for ( int i = 0;i < N ; i ++){
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(n);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
