/*
Question: Maximum of Absolute Value Expression
Given two arrays of integers with equal lengths, return the maximum value of:
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
where the maximum is taken over all 0 <= i, j < arr1.length.

Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13

Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20
 */

public class _9_MaximumOfAbsoluteValueExpression2 {

    // Brute force approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int maxAbsValExpr1(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int i = 0; i < arr1.length - 1; i++){
            for(int j = i + 1; j < arr1.length; j++){
                ans = Math.max(ans, Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i-j));
            }
        }
        return ans;
    }

    // Optimized approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int maxAbsValExpr2(int[] arr1, int[] arr2){
        int n = arr1.length;
        int[] val1 = new int[n];
        int[] val2 = new int[n];
        int[] val3 = new int[n];
        int[] val4 = new int[n];

        // Calculating first_array val1, second_array val2, third_array val3 and forth_array val4
        for (int i = 0; i < n; i++) {
            val1[i] = (i + arr1[i] + arr2[i]);
            val2[i] = (i + arr1[i] - arr2[i]);
            val3[i] = (i - arr1[i] + arr2[i]);
            val4[i] = (i - arr1[i] - arr2[i]);
        }
        int ans =0;
        ans = Math.max(ans, maxElementOfArray(val1) - minElementOfArray(val1));
        ans = Math.max(ans, maxElementOfArray(val2) - minElementOfArray(val2));
        ans = Math.max(ans, maxElementOfArray(val3) - minElementOfArray(val3));
        ans = Math.max(ans, maxElementOfArray(val4) - minElementOfArray(val4));

        return ans;
    }

    private int minElementOfArray(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            minElement = Math.min(minElement, arr[i]);
        }
        return minElement;
    }

    private int maxElementOfArray(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxElement = Math.max(maxElement, arr[i]);
        }
        return maxElement;
    }
}
