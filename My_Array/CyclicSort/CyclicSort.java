package My_Array.CyclicSort;

import java.util.Arrays;

public class CyclicSort {
    /**
     * Problem Statement #
     * We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.
     *
     * Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
     *
     * Example 1:
     *
     * Input: [3, 1, 5, 4, 2]
     * Output: [1, 2, 3, 4, 5]
     * Example 2:
     *
     * Input: [2, 6, 4, 3, 1, 5]
     * Output: [1, 2, 3, 4, 5, 6]
     */

    /**Solution :
     * As we know, the input array contains numbers in the range of 1 to ‘n’.
     * We can use this fact to devise an efficient way to sort the numbers.
     * Since all numbers are unique, we can try placing each number at its correct place,
     * i.e., placing ‘1’ at index ‘0’, placing ‘2’ at index ‘1’, and so on.
     */

    public static void sort(int[] nums) {

        int i = 0 ;
        while ( i < nums.length ){
            int j = nums[i]-1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
