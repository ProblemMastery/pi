package DP.LongestCommonPattern;

/*
Given 2 strings s = abcdaf andf t = acbcf,return the longest common subsequence = abcf
 */
public class LongestCommonSubsequence {

    /**
     * if s1[i] == s2[j]
     *   dp[i][j] = 1 + dp[i-1][j-1]
     * else
     *   dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * @param a
     * @param b
     * @return
     */
    public static int LongestCommonSubsequence(String a, String b){

        int [][]dp = new int [a.length()+1][b.length()+1];
        int max = 0;

        for(int i = 1 ; i < dp.length; i++){
            for (int j = 1 ; j < dp[0].length; j++){
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * Optimization on Space :
     */
    public static int LongestCommonSubsequenceOptimal(String a, String b) {

        int[][] dp = new int[2][b.length() + 1];
        int max = 0;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i%2][j] = 1 + dp[(i-1)%2][j - 1];
                else
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[i%2][j-1]);
                max = Math.max(max, dp[i%2][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonSubsequenceOptimal("abdca", "cbda"));
        System.out.println(LongestCommonSubsequenceOptimal("passport", "ppsspt"));
    }
}
