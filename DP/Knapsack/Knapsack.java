package DP.Knapsack;

public class Knapsack {

    /**
    Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
    The goal is to get the maximum profit out of the items in the knapsack.
    Each item can only be selected once, as we don’t have multiple quantities of any item.
     */

    /*
    Items: { Apple, Orange, Banana, Melon }
    Weights: { 2, 3, 1, 4 }
    Profits: { 4, 5, 3, 7 }
    Knapsack capacity: 5
     */

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {

        int n = profits.length;
        int [][] dp = new int [n][capacity+1];

        for (int i = 0 ; i < n ; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        for (int i = 1 ; i < n ; i++){
            for (int c = 1 ; c <= capacity; c++){
                int profit1 = 0; // curr weight included
                int profit2 = 0; // curr weight not included
                if (weights[i] <= c)
                    // include the item, if it is not more than the capacity
                    profit1 = dp[i-1][c- weights[i]] + profits[i];

                //exclude item
                profit2 = dp[i-1][c];
                // take maximum
                dp [i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[n-1][capacity];
    }



    /**
     * Challenge #
     * Can we improve our bottom-up DP solution even further? Space O(c)
     * Can you find an algorithm that has O(C)O(C) space complexity?
     * Soln : If you see closely, we need two values from the previous iteration: dp[c] and dp[c-weight[i]]
     * go from backwards :
     */

    public int solveKnapsackOptimal(int[] profits, int[] weights, int capacity) {

        int n = profits.length;
        int [] dp = new int [capacity+1];


        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[c] = profits[0];
        }

        for (int i = 1 ; i < n ; i++){
            for (int c = capacity ; c >= 0; c--){
                int profit1 = 0; // curr weight included
                int profit2 = 0; // curr weight not included
                if (weights[i] <= c)
                    // include the item, if it is not more than the capacity
                    profit1 = dp[c- weights[i]] + profits[i];

                //exclude item
                profit2 = dp[c];
                // take maximum
                dp [c] = Math.max(profit1, profit2);
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
