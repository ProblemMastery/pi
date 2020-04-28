package DP.UnboundedKnapsack;

public class UnboundedKnapsack {
    /**
     * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack
     * which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack.
     * The only difference between the 0/1 Knapsack problem and this problem is that we are allowed
     * to use an unlimited quantity of an item.
     * Eg :
     * Items: { Apple, Orange, Melon }
     * Weights: { 1, 2, 3 }
     * Profits: { 15, 20, 50 }
     * Knapsack capacity: 5
     *
     * 2 Apples + 1 Melon (total weight 5) => 80 profit
     *
     * So for every possible capacity ‘c’ (0 <= c <= capacity), we have two options:
     *
     * Exclude the item. In this case, we will take whatever profit we get from the sub-array excluding this item: dp[index-1][c]
     * Include the item if its weight is not more than the ‘c’. In this case, we include its profit plus whatever profit we get from the remaining capacity: profit[index] + dp[index][c-weight[index]]
     * Finally, we have to take the maximum of the above two values:
     *
     *     dp[index][c] = max (dp[index-1][c], profit[index] + dp[index][c-weight[index]])
     *
     */

    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int profit1 = 0, profit2 = 0;
                // profit1 is not including current item
                //profit2 is including current item
                if (i > 0)
                    profit1 = dp[i - 1][j];

                if (weights[i]<=j)
                    profit2 =  profits[i] + dp[i][j - weights[i]];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }
        // maximum profit will be in the bottom-right corner.
        return dp[n - 1][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        System.out.println(solveKnapsack(profits, weights, 8));
        System.out.println(solveKnapsack(profits, weights, 6));
    }
}
