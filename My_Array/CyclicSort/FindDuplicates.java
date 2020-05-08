package My_Array.CyclicSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDuplicates {
    /**
     * Problem Statement #
     * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
     * The array has only one duplicate but it can be repeated multiple times.
     * Find that duplicate number without using any extra space.
     * You are, however, allowed to modify the input array.
     *
     * Example 1:
     *
     * Input: [1, 4, 4, 3, 2]
     * Output: 4
     * Example 2:
     *
     * Input: [2, 1, 3, 3, 5, 4]
     * Output: 3
     * Example 3:
     *
     * Input: [2, 4, 1, 4, 4]
     * Output: 4
     */

    public static int findNumber(int[] nums) {

        int i = 0 ;
        while (i < nums.length){
             // if i = 0,  nums[i] = 2; nums[i]-1 = 1;-> more like pointer to array
            if (nums[i] != i+1) {
                if (nums [i] != nums[nums[i]-1])
                    swap(nums, i, nums[i]-1);
                else
                    return nums[i];
            }
            else
                i++;
        }
        return -1;
    }

    /**
     * Problem Statement #
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some duplicates, find all the duplicate numbers without using any extra space.
     *
     * Example 1:
     *
     * Input: [3, 4, 4, 5, 5]
     * Output: [4, 5]
     * Example 2:
     *
     * Input: [5, 4, 7, 2, 3, 5, 3]
     * Output: [3, 5]
     */

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        int i = 0 ;
        while (i < nums.length){
            int j = nums[i-1];// if i = 0,  nums[i] = 2; nums[i]-1 = 1;-> more like pointer to array
            if (nums[i] != j)
                    swap(nums, i, nums[i]-1);
            else
                i++;
        }

        for (int k = 0 ; k < nums.length; k++){
            if (nums[k] != k+1)
                duplicateNumbers.add(nums[k]);
        }

        return duplicateNumbers;

    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1, 4, 4, 3, 2}));

        List<Integer> duplicates = findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
