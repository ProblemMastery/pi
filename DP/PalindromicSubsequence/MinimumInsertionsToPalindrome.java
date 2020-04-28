package DP.PalindromicSubsequence;

public class MinimumInsertionsToPalindrome {

    /**
     * the length of the Longest Palindromic Subsequence is the best palindromic subsequence we can have.
     * Let’s take a few examples:
     *
     * Example 1:
     *
     * Input: "abdbca"
     * Output: 1
     * Explanation: By inserting “c”, we get a palindrome “acbdbca”.
     *
     * Example 2:
     *
     * Input: = "cddpd"
     * Output: 2
     */
    public static int findMinimumInsertions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        LongestPalindromicSubsequence  LPS = new LongestPalindromicSubsequence();

        return st.length() - LPS.findLPSLength(st);
    }
    public static void main(String[] args) {
        System.out.println(findMinimumInsertions("abdbca"));
        System.out.println(findMinimumInsertions("cddpd"));
    }
}
