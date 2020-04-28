package DP;
        import java.util.Arrays;
/*
https://leetcode.com/problems/jump-game-ii/
Given an array of non-negative integers,
you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
 */
public class MinimumJumps {


    public int jump(int[] nums) {

        int [] minJumps = new int [nums.length];

        Arrays.fill(minJumps, Integer.MAX_VALUE);
        for (int i = 1; i < nums.length; i++ ){
            for (int j = 0 ; j < i ; j++ ){

                if (i <= j +nums[j])
                    minJumps[i] = Math.min(minJumps[i], minJumps[j]+1);
            }
        }
        return minJumps[nums.length-1];
    }
}
