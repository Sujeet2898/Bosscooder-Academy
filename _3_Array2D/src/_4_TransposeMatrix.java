/*
Question: Transpose Matrix
Given a 2D integer array matrix, return the transpose of matrix.
The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
 */

public class _4_TransposeMatrix {

    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[n][m];  // switching the matrix's row and column
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}
