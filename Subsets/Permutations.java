package Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    /**
     * Given a set of distinct numbers, find all of its permutations.
     *
     * Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:
     *
     * {1, 2, 3}
     * {1, 3, 2}
     * {2, 1, 3}
     * {2, 3, 1}
     * {3, 1, 2}
     * {3, 2, 1}
     * If a set has ‘n’ distinct elements it will have n!n! permutations.
     *
     * Input: [1,3,5]
     * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
     */

    public static List<List<Integer>> findPermutations(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> permQueue = new LinkedList<>();
        permQueue.add(new ArrayList<>());

        for (int n : nums){
            int N = permQueue.size();
            for (int i = 0 ; i < N; i ++){
                List<Integer> oldPermutation = permQueue.poll();

                // create a new permutation by adding the current number at every position
                for (int j = 0 ; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, n);
                    if (newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permQueue.add(newPermutation);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
