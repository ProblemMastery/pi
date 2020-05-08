package My_Array.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
    /**
     * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
     * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the One missing number.
     *
     * Example 1:
     *
     * Input: [4, 0, 3, 1]
     * Output: 2
     * Example 2:
     *
     * Input: [8, 3, 5, 2, 4, 6, 0, 1]
     * Output: 7
     * @param nums
     * @return
     */
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
        if (nums[i] < nums.length && i != nums[i]) // if index == nums[i], move on
            swap(nums, i, nums[i]);
        else
            i++;
    }

    // find the first number missing from its index, that will be our required number
    for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
            return i;

    return nums.length;
}

    /**
     * Problem Statement #
     * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
     * The array can have duplicates, which means some numbers will be missing.
     * Find all those missing numbers.
     *
     * Example 1:
     *
     * Input: [2, 3, 1, 8, 2, 3, 5, 1]
     * Output: 4, 6, 7
     * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
     * Example 2:
     *
     * Input: [2, 4, 1, 2]
     * Output: 3
     */

    public static List<Integer> findNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length){
            int j = nums[i]-1;
            if (nums[i] != nums[j]){
                swap(nums, i, j);
            }
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

            return missingNumbers;
        }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
        List<Integer> missing = findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
