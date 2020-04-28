package DP;

public class PaintHouse {

    /*
    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different.
    You have to paint all the houses such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    For example, costs[0][0] is the cost of painting house 0 with color red;
    costs[1][2] is the cost of painting house 1 with color green, and so on...
    Find the minimum cost to paint all houses.

    Note:
        All costs are positive integers.

    Example:

    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
             Minimum cost: 2 + 5 + 3 = 10.
     */

    public static int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int rows = costs.length - 1;
        if (rows ==  0){
            Math.min(costs[rows][0], Math.min(costs[rows][1], costs[rows][2]));
        }

        for (int i = 1; i <= rows; i++) {

            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[rows][0], Math.min(costs[rows][1], costs[rows][2]));
    }

    public int minCost_2(int[][] costs) {

        if (costs.length == 0) return 0;

        int[] previousRow = costs[costs.length -1];

        for (int n = costs.length - 2; n >= 0; n--) {

            int[] currentRow = costs[n].clone();
            // Total cost of painting the nth house red.
            currentRow[0] += Math.min(previousRow[1], previousRow[2]);
            // Total cost of painting the nth house green.
            currentRow[1] += Math.min(previousRow[0], previousRow[2]);
            // Total cost of painting the nth house blue.
            currentRow[2] += Math.min(previousRow[0], previousRow[1]);
            previousRow = currentRow;
        }

        return Math.min(Math.min(previousRow[0], previousRow[1]), previousRow[2]);
    }

    // Time complexity : O(nk).
    // Space complexity : O(1).
    public static int paintHouseII(int [][] costs) {

        int k = costs[0].length;
        int n = costs.length;

        int prevMin = -1, prevMinColor = -1, prevSecondMin = -1;

        //for the first house find the min and second min
        for (int color = 0; color < k; color++) {

            int cost = costs[0][color];

            if (cost < prevMin || prevMin == -1) {
                // each time check cost < prevMin or if its the first time prevMin = -1

                prevSecondMin = prevMin;
                prevMinColor = color;
                prevMin = cost; // since cost is lesser than prev Min
            } else if (cost < prevSecondMin || prevSecondMin == -1)
                prevSecondMin = cost;
        }

        for (int house = 1; house < n; house++) {

            int min = -1, minColor = -1, secondMin = -1;
            for (int color = 0; color < k; color++) {
                int cost = costs[house][color];

                if (color == prevMinColor) {
                    // we cannot have 2 adj house with same color
                    //if so increment with second min
                    cost += prevSecondMin;
                } else {
                    //else increment with minimum;
                }


                // find the min cost in the current row/house
                if (cost < min || min == -1) {

                    secondMin = min;
                    minColor = color;
                    min = cost;
                } else if (cost < secondMin || secondMin == -1) {
                    secondMin = cost;
                }
                // transfer mins to prevMins
                prevMin = min;
                prevSecondMin = secondMin;
                prevMinColor = minColor;
            }
        }

        return prevMin;
    }

}
