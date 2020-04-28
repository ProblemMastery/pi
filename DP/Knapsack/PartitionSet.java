package DP.Knapsack;

public class PartitionSet {
    /**
     * Problem Statement #
     * Given a set of positive numbers,
     * find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
     *
     * Input: {1, 2, 3, 4}
     * Output: True
     * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
     */

    /**
     * Solution : This problem follows the 0/1 Knapsack pattern.
     * Assume that S represents the total sum of all the given numbers.
     * Then the two equal subsets must have a sum equal to S/2. This essentially transforms our problem to:
     * "Find a subset of the given numbers that has a total sum of S/2".
     * The  solution the has time and space complexity of O(N*S)O(N∗S),
     */

    public boolean canPartition(int[] num) {
        int N = num.length;

        int sum = 0 ;
        for (int n : num)
            sum += n;

        if (sum %2 != 0)
            return false;

        boolean [][] dp = new boolean[N][sum/2];

        // populate the sum=0 columns, as we can always for '0' sum with an empty set

        for (int i = 0 ; i < N ; i++)
            dp[i][0] = true;

        for (int s = 0 ; s <= sum/2; s++)
            dp[0][s] = num[0]== s ? true : false;

        for (int i = 1 ; i < N ; i++) {
            for (int s = 1; s <= sum / 2; s++) {

                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }
        return dp[N][sum/2];
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
