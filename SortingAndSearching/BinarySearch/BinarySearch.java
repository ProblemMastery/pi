package SortingAndSearching.BinarySearch;

public class BinarySearch {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    You are given a target value to search. If found in the array return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
    Your algorithm's runtime complexity must be in the order of O(log n).
     */

    /*
    Solution :
    The algorithm is quite straightforward :
    Find a rotation index rotation_index, i.e. index of the smallest element in the array. Binary search works just perfect here.
    rotation_index splits array in two parts. Compare nums[0] and target to identify in which part one has to look for target.
    Perform a binary search in the chosen part of the array.
     */

    public int getTargetIndexInSortedRotatedArray(int nums[], int target){

        int n = nums.length;
        //find the rotated index.
        if (n ==0){
            return  -1;
        }
        int rotatedIndex = getRotatedIndex(nums);
        if( nums[rotatedIndex] == target){
            return rotatedIndex;
        }

        //if the target is less than first element in the array,
        if(target < nums[0]){
            //search right, i.e from rotated index until end
            return binarySearch(nums, rotatedIndex, n-1, target);
        }

        return binarySearch(nums, 0, rotatedIndex, target);
    }

    public int getRotatedIndex(int [] nums){
        int n = nums.length;

        if(n == 0){
            return  -1;
        }
        int start = 0, end = n-1;

        while (start < end){
            int mid = (start + end )/2;

            if(nums[mid] > nums[mid+1]){
                //i.e the rotated index is found
                return mid;
            }
            else if(nums[mid] < nums[start]){
                //means rotated index is in right
                end = mid - 1;

            }else{
                start = mid+1;
            }

        }
        return -1;
    }
    /*
    returns index of the target
     */
    public int binarySearch(int[] nums, int lo, int hi, int target){

        while(lo < hi){
            int pivot = (lo + hi)/2;

            if(nums[pivot] == target){
                return pivot;
            }
            else if(nums[pivot] < target){
                //search right, so move lo pointer to pivot +1
                lo = pivot + 1;
            }else if(nums[pivot] > target ){
                //search left, so move hi pointer to pivot -1
                hi =  pivot - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }


}