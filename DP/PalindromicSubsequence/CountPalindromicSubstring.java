package DP.PalindromicSubsequence;

public class CountPalindromicSubstring {

    /**
     * Problem Statement #
     * Given a string, find the total number of palindromic substrings in it.
     Input: "abdbca"
     Output: 7
     Explanation: Here are the palindromic substrings, "a", "b", "d", "b", "c", "a", "bdb".

     Input: = "cddpd"
     Output: 7
     Explanation: Here are the palindromic substrings, "c", "d", "d", "p", "d", "dd", "dpd".
     Solution :
     This problem follows the Longest Palindromic Subsequence pattern,
     and can be easily converted to Longest Palindromic Substring.
     The only difference is that instead of calculating the longest palindromic substring,
     we will instead count all the palindromic substrings.

     DP Matrix : T indicates string i to j is a palindrome, when we update to T, we increase the count
     *      *      c   d   d   p   d
     *      0   c  T   F   F   F   F
     *      1   d  X   T   T   F   F
     *      2   d  X   X   T   F   T  ^  moving up
     *      3   p  X   X   X   T   F  |
     *      4   d  X   X   X   X   T
     *
     *      *   X--> dont care or F;
     *      When we update to True -> we check the max

     The time and space complexity of the above algorithm is O(n^2)
     where ‘n’ is the length of the input string.
     */

    public static int countPalindromicSubstring(String st) {
        boolean[][] dp = new boolean[st.length()][st.length()];
        int count = 0;

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int start = st.length(); start >=0; start--){
            for (int end = start+1; end < st.length(); end++){

                if (end-start == 1 || dp[start+1][end-1]){
                    dp[start][end] =true;
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPalindromicSubstring("abdbca"));
    }
}
