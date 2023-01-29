/*
Question: Largest Rectangle in Histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Input: heights = [2,4]
Output: 4
 */

import java.util.Stack;

public class _6_LargestRectangleInHistogram {

    // Brute force approach
    // Time Complexity: O(N^2)
    // Space Complexity: O(1) --> only a constant extra space is required.

    public int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    // LSE and RSE approach
    // Time Complexity: O(3N) --> for the stack, left small array and a right small array
    // Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array

    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];

        // finding leftSmall
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                leftSmall[i] = 0;
            }
            else {
                leftSmall[i] = st.peek() + 1;
            }
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) {
            st.pop();
        }

        // finding rightSmall
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                rightSmall[i] = n - 1;
            }
            else {
                rightSmall[i] = st.peek() - 1;
            }

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
}