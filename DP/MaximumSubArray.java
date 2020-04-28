package DP;

public class MaximumSubArray {

    /*
        Given an integer array nums,
        find the contiguous subarray (containing at least one number)
        which has the largest sum and return its sum.

        Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currSum = nums[0];

        /*
        each time, we compare whether the current element + prevSum so far or prev is greater than current
         */
        for(int i = 1 ; i < nums.length; i++){
            currSum =  Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
