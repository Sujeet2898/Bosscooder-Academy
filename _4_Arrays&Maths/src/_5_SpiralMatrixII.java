/*
Question: Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Input: n = 3
 1 -> 2 -> 3
           |
 8 -> 9    4
 |         |
 7 <- 6 <- 5
Output: [[1,2,3],[8,9,4],[7,6,5]]
 */

public class _5_SpiralMatrixII {

    // Time Complexity: O(n^2) -> Every element is visited once
    // Space Complexity: O(n^2) -> matrix
    public int[][] generateMatrix(int n) {

        // Declaration
        int[][] matrix = new int[n][n];

        // Normal Case
        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        int count = 1; //change

        while (minRow <= maxRow && minCol <= maxCol){

            // top wall
            for (int i = minRow, j = minCol; j <= maxCol; j++){
                matrix[minRow][j] = count++; //change
            }
            minRow++;

            // right wall
            for (int i = minRow, j = maxCol; i <= maxRow; i++){
                matrix[i][maxCol] = count++; //change
            }
            maxCol--;

            // bottom wall
            for (int i = maxRow, j = maxCol; j >= minCol; j--){
                matrix[maxRow][j] = count++; //change
            }
            maxRow--;

            // left wall
            for (int i = maxRow, j = minCol; i >= minRow; i--){
                matrix[i][minCol] = count++; //change
            }
            minCol++;
        }

        return matrix;
    }
}
