/*
Question: Maximum value of |arr[i] – arr[j]| + |i – j|
Given a array of N positive integers. The task is to find the maximum value of |arr[i] – arr[j]| + |i – j|,
where 0 <= i, j <= N – 1 and arr[i], arr[j] belong to the array.

Input : N = 4, arr[] = { 1, 2, 3, 1 }
Output : 4
Explanation:
Choose i = 0 and j = 2. This will result in |1-3|+|0-2| = 4 which is the maximum possible value.

Input : N = 3, arr[] = { 1, 1, 1 }
Output : 2
 */

public class _1_MaximumofAbsoluteValueExpression {

    // Brute force approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int maxAbsValExpr1(int arr[]) {
        int n = arr.length;
        int ans = 0;

        // Iterating two for loop, one for i and another for j.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Evaluating |arr[i] - arr[j]| + |i - j| and compare with previous maximum.
                ans = Math.max(ans, Math.abs(arr[i] - arr[j]) + Math.abs(i - j));
            }
        }

        return ans;
    }

    // Optimized approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    /*
    First lets make four equations by removing the absolute value signs (“|”). The following 4 equations will be formed, and we need to find the maximum value of these equations and that will be our answer.
    1. arr[i] – arr[j] + i – j = (arr[i] + i) – (arr[j] + j)
    2. arr[i] – arr[j] – i + j = (arr[i] – i) – (arr[j] – j)
    3. -arr[i] + arr[j] + i – j = -(arr[i] – i) + (arr[j] – j)
    4. -arr[i] + arr[j] – i + j = -(arr[i] + i) + (arr[j] + j)
    Observe the equations (1) and (4) are identical. Similarly, equations (2) and (3) are identical.
     */
    public int maxAbsValExpr2(int arr[]){
        int n = arr.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int tmp;

        // Calculating first_array a and second_array b
        for (int i = 0; i < n; i++) {
            a[i] = (arr[i] + i);
            b[i] = (arr[i] - i);
        }

        int max = a[0];
        int min = a[0];

        // Finding maximum and minimum value in first_array a
        for (int i = 0; i < n; i++){
            if (a[i] > max)
                max = a[i];

            if (a[i] < min)
                min = a[i];
        }

        // Storing the difference between maximum and minimum value in first_array
        int ans1 = (max - min);

        max = b[0];
        min = b[0];

        // Finding maximum and minimum value in second_array b
        for (int i = 0; i < n; i++){
            if (b[i] > max)
                max = b[i];

            if (b[i] < min)
                min = b[i];
        }

        // Storing the difference between maximum and minimum value in second_array
        int ans2 = (max - min);

        return Math.max(ans1, ans2);
    }
}
