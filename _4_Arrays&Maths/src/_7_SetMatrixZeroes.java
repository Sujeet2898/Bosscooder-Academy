/*
Question: Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
 */

public class _7_SetMatrixZeroes {

    // Time Complexity: O(m*m*n)
    // Space Complexity: O(m*n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean[][] isZero = new Boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                isZero[i][j] = false;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < m; k++){
                        isZero[k][j] = true;
                    }
                    for(int k = 0; k < n; k++){
                        isZero[i][k] = true;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isZero[i][j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
