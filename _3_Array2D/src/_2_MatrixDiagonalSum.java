/*
Question: Matrix Diagonal Sum
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
 */

public class _2_MatrixDiagonalSum {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        //For each row, we need to pick elements from both the diagonals.
        for(int i = 0; i < n; i++){
            sum += mat[i][i] + mat[i][n-1-i];
        }

        if(n % 2 == 0){
            return sum;
        }
        //If the matrix has odd number of rows then we'd have added the central element twice. Hence we need to remove it once.
        else{
            return sum - mat[n/2][n/2];
        }
    }
}
