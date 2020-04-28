package SortingAndSearching.BinarySearch;

public class SearchRotatedArray {

    /**
     * Given an array of numbers which is sorted in ascending order and
     * also rotated by some arbitrary number, find if a given ‘key’ is present in it.
     * Write a function to return the index of the ‘key’ in the rotated array.
     * If the ‘key’ is not present, return -1. You can assume that the given array does not have any duplicates.
     *
     * Input: [10, 15, 1, 3, 8], key = 15
     * Output: 1
     *
     * Input: [4, 5, 7, 9, 10, -1, 2], key = 10
     * Output: 4
     * Explanation: '10' is present in the array at index '4'.
     */

    public static int search(int[] arr, int key) {

        int start = 0 ;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (key == arr[mid])
                return mid;

            if (arr[start] <= arr[mid]) { // first half ascending

                if (key >=arr[start] && key < arr[mid]) // key lies between start and mid
                    end = mid - 1;
                else  // key lies outside start to mid means from mid to end
                    start = mid + 1;
            }
            else {   // second half is ascending,
                //  key can lie between mid to end window
                if (key > arr[mid] && key < arr[end])
                     start = mid +1;
                else //  key lies outside mid to end means from start to mid
                    end = mid -1;
            }
        }
        return -1;
    }

    /**
     * Problem 2 #
     * How do we search in a sorted and rotated array that also has duplicates?
     * The code above will fail in the following example!
     *
     * Example 1:
     *
     * Input: [3, 7, 3, 3, 3], key = 7
     * Output: 1
     * Explanation: '7' is present in the array at index '1'.
     * Solution #
     * The only problematic scenario is when the numbers at indices start, middle, and end are the same,
     * as in this case, we can’t decide which part of the array is sorted.
     * In such a case, the best we can do is to skip one number from both ends: start = start + 1 & end = end - 1.
     */
    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
