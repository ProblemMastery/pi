package DP.UnboundedKnapsack;

public class CoinChange {

    /**
     * Given an infinite supply of ‘n’ coin denominations and a total money amount,
     * we are asked to find the total number of distinct ways to make up that amount.
     *
     * Denominations: {1,2,3}
     * Total amount: 5
     * Output: 5
     * Explanation: There are five ways to make the change for '5', here are those ways:
     *   1. {1,1,1,1,1}
     *   2. {1,1,1,2}
     *   3. {1,2,2}
     *   4. {1,1,3}
     *   5. {2,3}
     *
     *   Formula :
     *   dp[TotalDenominations][Total+1]
     *       dp[index][t] = dp[index-1][t] + dp[index][t-denominations[index]]
     */

    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        int [][] dp = new int [n][total+1];

        for (int i = 0 ; i < n; i++)
            dp[i][0] = 0;

        for (int i = 0 ; i < n ; i++){
            for (int t = 1; t <= total; t++){

                if (i > 0)
                    dp[i][t] = dp[i - 1][t];
                if (denominations[i] <= t)
                    dp[i][t] += denominations[i]+ dp[i][t - denominations[i]];

            }
        }
        // total combinations will be at the bottom-right corner.

       return dp[n-1][total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
    }
}
