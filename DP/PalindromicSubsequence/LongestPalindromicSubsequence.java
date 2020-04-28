package DP.PalindromicSubsequence;

public class LongestPalindromicSubsequence {
    /**
     * Given a sequence, find the length of its Longest Palindromic Subsequence (LPS).
     * In a palindromic subsequence, elements read the same backward and forward.
     * Eg : Example 1:
     *
     * Input: "abdbca"
     * Output: 5
     * Explanation: LPS is "abdba".
     *
     * Input: = "cddpd"
     * Output: 3
     * Explanation: LPS is "ddd".
     *
     * Input: = "pqr"
     * Output: 1
     * Explanation: LPS could be "p", "q" or "r".
     *
     * Solution :
     * So for every startIndex and endIndex in the given string,
     * we will choose one of the following two options:
     *
     * --> If the element at the startIndex matches the element at the endIndex,
     * the length of LPS would be two plus the length of LPS till startIndex+1 and endIndex-1.
     * -->If the element at the startIndex does not match the element at the endIndex,
     * we will take the maximum LPS created by either skipping element at the startIndex or the endIndex.
     *
     * So our recursive formula would be:
     *
     * if st[endIndex] == st[startIndex]
     *   dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1]
     * else
     *   dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1])
     *
     *   DP Matrix :
     *      c   d   d   p   d
     *   c  1   1   2   2   3 --> answer
     *   d  X   1   2   2   3
     *   d  X   X   1   1   3  ^  moving up
     *   p  X   X   X   1   1  |
     *   d  X   X   X   X   1
     *   X--> dont care or 0;
     *
     *   The time and space complexity of the above algorithm is O(n^2)
     * ​
     * ​​  where ‘n’ is the length of the input sequence.
     */
    public static int findLPSLength(String st) {

        int Len = st.length();
        int [][] dp = new int [Len][Len];

        // dp has the longest palindromic subsequence;
        // dp [i][i] that is for every character, its own self is a palindrome of size 1;
        for (int i = 0 ;i < Len; i++){
            dp[i][i]= 1;
        }

        // fill the table bottom up from (3,4)  , (2,3, (2,4), (1,2),(1,3)(1,4), then (0,1)(0,2)(0,3)(0,4)(0,5)
        for (int i = Len -1 ; i >=0; i-- ){
            for (int j = i+1; j <Len; j++)
                if(st.charAt(i)==st.charAt(j))
                    dp[i][j] = 2+ dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
        }
        return dp[0][Len-1];
    }
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }
}
