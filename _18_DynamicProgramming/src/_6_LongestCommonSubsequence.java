/*
Question: Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */

import java.util.Map;

public class _6_LongestCommonSubsequence {

    // Tabulation (DP) #9 ms
    // TC: n*m
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i -1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // Memoization (DP) using Matrix #15 ms
    int lcsDP(String text1, String text2, int n, int m, int[][] dp) {
        // base case
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        int lcs = 0;
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            lcs = 1 + lcsDP(text1, text2, n - 1, m - 1, dp);
        } else {
            lcs = Math.max(lcsDP(text1, text2, n - 1, m, dp), lcsDP(text1, text2, n, m - 1, dp));
        }

        return dp[n][m] = lcs;
    }

    // Recursive #TLE
    // TC: 2^n * 2^m (2 recursive call)
    int lcs(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (text1.charAt(n - 1) == text2.charAt(m - 1))
            return 1 + lcs(text1, text2, n - 1, m - 1);

        return Math.max(lcs(text1, text2, n - 1, m), lcs(text1, text2, n, m - 1));
    }

}
