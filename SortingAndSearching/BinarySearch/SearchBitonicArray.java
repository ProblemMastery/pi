package SortingAndSearching.BinarySearch;

public class SearchBitonicArray {

    /**
     * Search Bitonic Array (medium) #
     * Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
     *
     * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
     *
     * Input: [1, 3, 8, 4, 3], key=4
     * Output: 3
     *
     * Input: [3, 8, 3, 1], key=8
     * Output: 1
     */

    /***
     * Like our max in Bitonic array, we need to find the index of max in bitonic and then do order agnostic BS
     *
     * Step 1: find index of max in array
     * step 2: do BS from 0 to maxIndex - sorted ascending order
     * Step 3: do BS from maxIndex+1 to end - descending order
     *
     */


    public static int search(int[] arr, int key) {

        int maxIndex = findMax(arr);

        int keyIndexAsc = binarySearch(arr, key, 0, maxIndex);
        if (keyIndexAsc != -1)
            return keyIndexAsc;

        return binarySearch(arr, key, maxIndex+1, arr.length-1);
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {

        while (start <= end){

            int mid = start + (end - start)/2;

            if (key == arr[mid])
                return mid;

            if (arr[start] < arr[end]){ // ascending arr
                if ( key > arr[mid])
                    start = mid +1;
                else
                    end = mid-1;
            } else {
                // descending
                if ( key > arr[mid])
                    end = mid -1;
                else
                    start = mid+1;
            }
        }
        return  -1;
    }

    public static int findMax(int[] arr) {

        int start = 0 ;
        int end = arr.length-1;

        while (start < end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1])
                end = mid;
            else {
                start = mid+1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[]{1, 3, 8, 4, 3}, 4));
        System.out.println(SearchBitonicArray.search(new int[]{3, 8, 3, 1}, 8));
    }
}
