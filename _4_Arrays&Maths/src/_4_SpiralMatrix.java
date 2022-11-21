/*
Question: Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

 1 -> 2 -> 3
           |
 4 -> 5    3
 |         |
 1 <- 2 <- 3

Output: [1,2,3,6,9,8,7,4,5]
 */

import java.util.ArrayList;
import java.util.List;

public class _4_SpiralMatrix {

    // Time Complexity: O(m*n) -> Every element is visited once.
    // Space Complexity: O(1) -> excluding the result space.
    public List<Integer> spiralOrder1(int[][] matrix) {

        // Declaration
        List<Integer> list = new ArrayList<>();

        // Normal Case
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length - 1;  // m
        int maxCol = matrix[0].length - 1;  // n

        while (minRow <= maxRow && minCol <= maxCol){

            // top wall
            for (int i = minRow, j = minCol; j <= maxCol; j++){
                list.add(matrix[minRow][j]);
            }
            minRow++;

            // right wall
            for (int i = minRow, j = maxCol; i <= maxRow; i++){
                list.add(matrix[i][maxCol]);
            }
            maxCol--;

            // bottom wall
            if(minRow <= maxRow){ // proceed only if there is either an unvisited row
                for (int i = maxRow, j = maxCol; j >= minCol; j--){
                    list.add(matrix[maxRow][j]);
                }
                maxRow--;
            }

            // left wall
            if(minCol <= maxCol){ // proceed only if there is either an unvisited column
                for (int i = maxRow, j = minCol; i >= minRow; i--){
                    list.add(matrix[i][minCol]);
                }
                minCol++;
            }
        }

        return list;
    }
}
