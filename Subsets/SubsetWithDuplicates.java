package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    /**
     * Given a set of numbers that might contain duplicates, find all of its distinct subsets.
     * Input: [1, 3, 3]
     * Output: [], [1], [3], [1,3], [3,3], [1,3,3]
     */

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        Arrays.sort(nums);

        int startIndexInSubsetListToAdd = 0, endIndex = 0;
        subsets.add(new ArrayList<>());
        for (int i = 0 ; i < nums.length; i++){
             startIndexInSubsetListToAdd = 0;
            if (i > 0 && nums[i] == nums[i-1])
                startIndexInSubsetListToAdd = endIndex+1;
            endIndex = subsets.size() - 1;
            for (int j = startIndexInSubsetListToAdd; j <= endIndex ; j++){
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
