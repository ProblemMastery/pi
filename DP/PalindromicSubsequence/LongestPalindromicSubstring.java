package DP.PalindromicSubsequence;

public class LongestPalindromicSubstring {

    /**
     * Problem Statement #
     * Given a string, find the length of its Longest Palindromic Substring (LPS).
     * In a palindromic string, elements read the same backward and forward.
     *
     * Input: "abdbca"
     * Output: 3
     * Explanation: LPS is "bdb".
     *
     * Input: = "cddpd"
     * Output: 3
     * Explanation: LPS is "dpd".
     *
     * Solution :
     * This problem follows the Longest Palindromic Subsequence pattern.
     *  So dp[i][j] will be ‘true’ if the substring from index ‘i’ to index ‘j’ is a palindrome.
     *  if st[startIndex] == st[endIndex], and
     *         if the remaing string is of zero length or dp[startIndex+1][endIndex-1] is a palindrome then
     *    dp[startIndex][endIndex] = true
     *     DP Matrix :
     *      *      c   d   d   p   d
     *      *   c  T   F   F   F   F
     *      *   d  X   T   T   F   F
     *      *   d  X   X   T   F   T  ^  moving up
     *      *   p  X   X   X   T   F  |
     *      *   d  X   X   X   X   T
     *      *   X--> dont care or F;
     *      When we update to True -> we check the max
     */
    public static int findLPSLength(String st) {
        // dp[i][j] will be 'true' if the string from index 'i' to index 'j' is a
        // palindrome
        boolean[][] dp = new boolean[st.length()][st.length()];

        // every string with one character is a palindrome
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = true;

        int maxLength = 1;
        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    // if it's a two character string or if the remaining string is a palindrome too
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex - startIndex + 1);
                    } // else false;
                }
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cdpdd"));
        System.out.println(findLPSLength("pqr"));
    }
}
