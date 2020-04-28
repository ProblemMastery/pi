package DP;

public class MinimumPathSum {

    /*
    https://leetcode.com/problems/minimum-path-sum/
    Given a m x n grid filled with non-negative numbers,
    find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */

    public static int getMinPath_SubOptimal(int [][] grid) {

        int[][] T = new int[grid.length][grid[0].length];

        T[0][0] = grid[0][0];

        for (int j = 1; j < grid[0].length; j++) {
            T[0][j] = T[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            T[i][0] = T[i - i][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                T[i][j] = Math.min(T[i][j - 1], T[i - 1][j]) + grid[i][j];
            }
        }
        return T[grid.length - 1][grid[0].length-1];
    }

    public static int getMinPath(int [][] grid){

        int [] T = new int [grid[0].length];
        T[0] = grid[0][0];

        for (int j = 1; j < grid[0].length; j++) {
            T[j] = T[j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0)
                    T[j] = T[j]+grid[i][j];
               else
                   T[j] = Math.min(T[j-1], T[j])+grid[i][j];
            }
        }

        return T[grid[0].length-1];

    }

    public static void main(String args[]) {
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.print(getMinPath(input));
        }
}
