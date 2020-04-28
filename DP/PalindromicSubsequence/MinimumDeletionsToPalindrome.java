package DP.PalindromicSubsequence;

public class MinimumDeletionsToPalindrome {
    /**
     * Problem Statement #
     * Given a string, find the minimum number of characters that we can remove to make it a palindrome.
     *
     * Example 1:
     * Input: "abdbca"
     * Output: 1
     * Explanation: By removing "c", we get a palindrome "abdba".
     * Example 2:
     *
     * Input: = "cddpd"
     * Output: 2
     * Explanation: Deleting "cp", we get a palindrome "ddd".
     *
     * Solution :
     * Solution #
     * This problem can be easily converted to the Longest Palindromic Subsequence (LPS) problem.
     * We can use the fact that LPS is the best subsequence we can have,
     * so any character that is not part of LPS must be removed.
     * Formula :
     * Minimum_deletions_to_make_palindrome = Length(st) - LPS(st)
     *
     *
     */

    public static int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        LongestPalindromicSubsequence  LPS = new LongestPalindromicSubsequence();

        return st.length() - LPS.findLPSLength(st);
    }

    public static void main(String[] args) {
        System.out.println(findMinimumDeletions("abdbca"));
        System.out.println(findMinimumDeletions("cddpd"));
    }

}
