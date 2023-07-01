/*
Question: Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */

import java.util.Arrays;

public class _5_MinimumPathSum {

    // Recursion:
    public int minPathSum1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return minPathSum1(0,0,n,m,grid);
    }

    public int minPathSum1(int i, int j, int n, int m, int[][] grid){
        if(i >= n || j >=m)
            return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1)
            return grid[i][j];

        return grid[i][j] + Math.min(minPathSum1(i+1, j, n, m,grid), minPathSum1(i, j+1, n,m,grid));
    }

    // Memoization
    public int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        for(int[] num : memo)
            Arrays.fill(num, -1);
        return minPathSum2(0,0,n,m,grid, memo);
    }

    public int minPathSum2(int i, int j, int n, int m, int[][] grid, int[][] memo){
        if(i >= n || j >=m)
            return Integer.MAX_VALUE;

        if(i == n-1 && j == m-1)
            return grid[i][j];
        if(memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = grid[i][j] + Math.min(minPathSum2(i+1, j, n, m,grid, memo), minPathSum2(i, j+1, n,m,grid,memo));
    }

    // Tabulization
    public int minPathSum(int[][] grid) {
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(i == 0 && j == 0)
                    grid[i][j] = grid[i][j];

                else if(i == 0 && j != 0){
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }
                else if(i!= 0 && j == 0)
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                else
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
