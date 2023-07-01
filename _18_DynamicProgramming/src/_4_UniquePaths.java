/*
Question: Unique Paths
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
1 <= m, n <= 100
 */

public class _4_UniquePaths {

    // Recursive approach:
    // TC: O(pow(2, m*n))
    // SC: O(m+n) for stack space
    public int uniquePaths1(int m, int n) {
        // base case
        if(m == 1 || n == 1) return 1;

        // move down
        int downMove = uniquePaths1(m-1, n);
        // move right
        int rightMove = uniquePaths1(m, n-1);

        return downMove + rightMove;
    }

    // Approach: top down recursive with memo array
    // Time: O(m*n) since we are filling up the array
    // Space: O(m*n) -> memo array
    public int uniquePaths2(int m, int n) {
        int[][] memo = new int[m][n];

        return recurse(m-1, n-1, memo); // 0 indexing
    }

    public int recurse(int m, int n, int[][] memo) {
        if (m == 0) {
            return 1; // only 1 path to get to intermediary at m == 0
        }
        if (n == 0) {
            return 1; // only 1 path to get to intermediary at n == 0
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        int path1 = recurse(m-1, n, memo);
        int path2 = recurse(m, n-1, memo);
        memo[m][n] = path1 + path2;
        return path1 + path2;
    }

    // DP approach:
    // 2D Tabulation: Time Complexity(O(mn)), Space Complexity(O(mn))
    public int uniquePaths3(int m, int n) {
        // Creates a 2D integer array of size m*n
        int[][] dp = new int[m][n];

        // Nested for loop to iterate through the 2D array
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                // If i or j is 0, then set the value at that index to 1
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                    // Otherwise, set the value to the sum of the value at the index to the left and above
                else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        // Return the value at the bottom-right corner of the 2D array
        return dp[m-1][n-1];
    }

    // 1D Tabulation: Time Complexity(O(mn)), Space Complexity(O(n))
    int prev[]; // Declare two integer arrays called prev and curr
    int curr[];
    public int uniquePaths(int m, int n) {
        prev = new int[n];
        curr = new int[n];
        // Initialize the prev array to have size n and set all values to 1
        for(int i=0; i<n; i++){
            prev[i] = 1;
        }
        // Nested for loop to iterate through the grid
        for(int i = 1; i<m; i++){
            // Initialize the first element of the curr array to be 1
            curr[0] = 1;
            for(int j=1; j<n; j++){
                // Set the value at index j of curr to be the sum of the value to the left and above
                curr[j] = curr[j-1] + prev[j];
            }
            // Copy the values in curr to prev
            for(int k = 0; k<n; k++){
                prev[k] = curr[k];
            }
        }

        // Return the value in prev at index n-1
        return prev[n-1];
    }
}
