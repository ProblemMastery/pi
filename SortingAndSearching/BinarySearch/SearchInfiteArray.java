package SortingAndSearching.BinarySearch;



public class SearchInfiteArray {

    /**
     * Problem Statement #
     * Given an infinite sorted array (or an array with unknown size),
     * find if a given number ‘key’ is present in the array.
     * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
     *
     * Since it is not possible to define an array with infinite (unknown) size,
     * you will be provided with an interface ArrayReader to read elements of the array.
     * ArrayReader.get(index) will return the number at index;
     * if the array’s size is smaller than the index, it will return Integer.MAX_VALUE.
     */

    class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }
        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    /**
     * We first need to find the bounds for the array.
     * Step 1: we know start is 0, we start from start = 0, end = 1;
     * Step 2: Each time we check if key > A[end].
     * Step 3: until the above condition is true, we keep iterating,
     * Step4 : when we iterate, we keep doubling the end, i.e the upper bound.i.e from 1->2->4->8->16
     * @param reader
     * @param key
     * @return
     */
    public static int search(ArrayReader reader, int key) {

        int start = 0 ;
        int end = 1;
        while (reader.get(end) < key) {// keep expanding the window until this is true.
            int newStart = end+1;
            end = (end - start +1)*2;
            start = newStart;
        }

        return binarySearch(reader, start, end, key);
    }

    private static int binarySearch(ArrayReader reader, int start, int end, int key) {

        while (start <= end){
            int mid = start + (end - start)/2;
            if (key > reader.get(mid)){
                start = mid+1;
            }else if (key < reader.get(mid)){
                end = mid -1;
            }else {
                return mid;
            }
        }
        return  -1;
    }
}




