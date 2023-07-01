/*
Question: Unique Paths 2
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */

public class _11_UniquePaths2 {

    // 1. Recursion
    // Time Complexity: Exponential, O(2^(m+n)), where m and n are the dimensions of the obstacleGrid.
    //  Space Complexity: O(m+n), as the maximum depth of the recursion tree is m+n.
    /*
    Intuition: The first implementation uses recursion to solve the problem of finding the number of unique paths to reach the bottom-right cell of a grid from the top-left cell with obstacles. It first initializes the size of the grid by obtaining the number of rows and columns from the input matrix obstacleGrid.
The helper() method takes the grid matrix, the current row r, the current column c, the total number of rows m, and the total number of columns n as its parameters. It returns the number of unique paths from the current cell to the bottom-right cell.
The first two if conditions check if the current cell is out of the grid bounds or is an obstacle. If either of these conditions is true, it returns 0 since no path exists from this cell. If the current cell is the bottom-right cell, it checks if it's an obstacle. If it is, it returns 0; otherwise, it returns 1 since there is only one unique path from the bottom-right cell to itself.
The last line of the helper() method calls itself recursively, calculating the number of unique paths from the cell below the current cell and adding it to the number of unique paths from the cell to the right of the current cell. Since it explores all possible paths, it returns the correct answer.
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return helper(obstacleGrid,0,0,m,n);
    }
    public int helper(int[][] grid,int r,int c,int m,int n){
        if(r == m || c == n || grid[r][c] == 1)return 0;
        if(r == m-1 && c == n-1){
            if(grid[r][c] == 1)return 0;
            return 1;
        }
        return helper(grid,r+1,c,m,n)+helper(grid,r,c+1,m,n);
    }

    // 2. Recustion + Memorization
    // Time Complexity: O(mn), as we are solving subproblems only once and storing their results in a 2D array.
    // Space Complexity: O(mn), for the memoization array.
    /*
    Intuition: The second implementation uses recursion with memoization to avoid recomputing the same subproblems. It has the same time complexity as the first implementation, which is O(2^(m+n)), but it avoids recomputing the same subproblems by storing the results of subproblems in a 2D memoization array dp.
The function helper is called recursively, and it takes in the grid, the current row r, the current column c, the total number of rows m and columns n, and the memoization array dp. It checks if the current cell is out of bounds or is an obstacle. If so, it returns 0. If the current cell is the destination cell, it returns 1.
Otherwise, it checks if the result for the current subproblem is already computed and stored in dp. If it is, it returns the stored value. Otherwise, it computes the result by recursively calling helper for the cell below and to the right of the current cell, and adds the results. It then stores the result in dp for future use.
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        return helper(obstacleGrid,0,0,m,n,dp);
    }
    public int helper(int[][] grid,int r,int c,int m,int n,int[][] dp){
        if(r == m || c == n || grid[r][c] == 1)return 0;
        if(r == m-1 && c == n-1){
            if(grid[r][c] == 1)return 0;
            return 1;
        }
        if(dp[r][c] > 0)return dp[r][c];
        return dp[r][c] = helper(grid,r+1,c,m,n,dp)+helper(grid,r,c+1,m,n,dp);
    }

    // 3. DP
    // Time Complexity: O(mn), as we are solving subproblems in a bottom-up manner, and each subproblem takes constant time.
    // Space Complexity: O(mn), for the DP array.
    /*
    Intuition: The second implementation uses recursion with memoization to avoid recomputing the same subproblems. It has the same time complexity as the first implementation, which is O(2^(m+n)), but it avoids recomputing the same subproblems by storing the results of subproblems in a 2D memoization array dp.
The function helper is called recursively, and it takes in the grid, the current row r, the current column c, the total number of rows m and columns n, and the memoization array dp. It checks if the current cell is out of bounds or is an obstacle. If so, it returns 0. If the current cell is the destination cell, it returns 1.
Otherwise, it checks if the result for the current subproblem is already computed and stored in dp. If it is, it returns the stored value. Otherwise, it computes the result by recursively calling helper for the cell below and to the right of the current cell, and adds the results. It then stores the result in dp for future use.
     */
    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                    if(obstacleGrid[i][j] == 1)dp[i][j] = 0;
                    else dp[i][j] = 1;
                }else if(i == m-1 || j == n-1){
                    if(obstacleGrid[i][j] == 1)dp[i][j] = 0;
                    else if(i == m-1)dp[i][j] = dp[i][j+1];
                    else if(j == n-1)dp[i][j] = dp[i+1][j];
                }else{
                    if(obstacleGrid[i][j] == 1)dp[i][j] = 0;
                    else dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
