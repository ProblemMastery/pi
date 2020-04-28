package DP.UnboundedKnapsack;

public class RodCutting {

    /**
     * Problem Statement #
     * Given a rod of length ‘n’, we are asked to cut the rod and
     * sell the pieces in a way that will maximize the profit.
     * We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
     *
     * Lengths: [1, 2, 3, 4, 5]
     * Prices: [2, 6, 7, 10, 13]
     * Rod Length: 5
     *
     * Formula :
     * dp[index][len] = max (dp[index-1][len], prices[index] + dp[index][len-lengths[index]])
     */

    public int solveRodCutting(int[] lengths, int[] prices, int n) {

        int L = lengths.length;
        int [][] dp = new int[L][n+1];

        for (int i = 0 ; i < L; i++){
            for (int l = 1; l <= n ; l++){

                int profit1 = 0, profit2 = 0;
                // profit1 is not including current item
                //profit2 is including current item
                if (i > 0)
                    profit1 = dp[i - 1][l];
                if (lengths[i] <= l)
                    profit2 = prices[i]+ dp[i][l - lengths[i]];
                dp[i][l] = Math.max(profit1,profit2);
            }
        }
        // maximum price will be at the bottom-right corner.
        return dp[L-1][n];
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }

}
