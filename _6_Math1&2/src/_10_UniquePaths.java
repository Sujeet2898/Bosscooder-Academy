/*
Question : Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */

public class _10_UniquePaths {

    // Recursive approach
    // Time Complexity: O(2^n)
    // Space Complexity: O(2^n)

    private static int uniquePathsRecursionHelper(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        return uniquePathsRecursionHelper(m - 1, n) + uniquePathsRecursionHelper(m, n - 1);
    }

    // Uding DP (Tabulation)
    // Time Complexity: O(M * N) --> Since we are running a nested loop  M * N times
    // Space Complexity: O(M * N) --> Since we are storing elements in a 2-D Array, total space taken will of the order M * N

    public static int uniquePaths1(int m, int n) {
        // Reference table to store subproblems.
        int[][] dp = new int[m][n];

        // Paths to reach a cell in column 1.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Paths to reach a cell in row 1.
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Bottom up approach.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Returning answer.
        return dp[m - 1][n - 1];
    }

/*
Since we are running a nested loop  M * N times, Thus the time complexity will be O(M * N).
Since we are storing elements in an array of size N, Thus the space complexity will be O(N).
 */

    public static int uniquePaths2(int m, int n) {
        // Reference array to store subproblems.
        int[] dp = new int[n];
        dp[0] = 1;

        // Bottom up approach.
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        // Returning answer.
        return dp[n - 1];
    }
}