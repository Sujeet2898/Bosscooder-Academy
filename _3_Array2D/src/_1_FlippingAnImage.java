/*
Question: Flipping an image
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */

public class _1_FlippingAnImage {

    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int[][] flipAndInvertImage1(int[][] image) {
        for(int i = 0; i < image.length; i++){
            int left = 0;
            int right = image[i].length - 1;

            // flipping and inverting each rows
            while(left <= right){
                int temp = image[i][left];
                image[i][left] = image[i][right] == 1 ? 0 : 1;
                image[i][right] = temp == 1 ? 0 : 1;
                left++;
                right--;
            }
        }
        return image;
    }

    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int[][] flipAndInvertImage2(int[][] image) {
        int m = image.length;
        int n = image[0].length;

        // iterate through all the rows
        for(int i = 0; i < m; i++) {
            // iterate only half through the columns as the remainder will undo what we did and return the original input with inverted values
            for(int j = 0; j < n/2; j++) {
                int temp = image[i][n-1-j];
                // apply bitwise operation to invert the values
                image[i][n-j-1] = image[i][j] ^ 1;
                image[i][j] = temp ^ 1;
            }

            // if the matrix is odd in length then we'd skip the middle element as per the above logic, so inverting the value explicitly
            if(m % 2 == 1) {
                image[i][m/2] = image[i][m/2] ^ 1;
            }
        }
        return image;
    }
}
