/*
Question: Aggressive Cows
There is a new barn with N stalls and C cows. The stalls are located on a straight line at positions x1,….,xN (0 <= xi <= 1,000,000,000).
We want to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.
What is the largest minimum distance?
Input: No of stalls = 5
       Array: {1,2,8,4,9}
       And number of cows: 3
Output: One integer, the largest minimum distance 3
 */

import java.util.Arrays;

public class _4_AggressiveCows {

    // Brute Force Approach
    // Time Complexity: O((max - min) * N)
    // Space Complexity: O(1) --> No extra space is used.


    public static int aggressiveCows1(int[] arr, int N, int C){  // N --> stall & C --> Cows
        Arrays.sort(arr);
        int maxDist = arr[N - 1] - arr[0];
        int ans = Integer.MIN_VALUE;

        for (int d = 1; d <= maxDist; d++) {
            boolean possible = isPossible1(arr, N, C, d);
            if (possible) {
                ans = Math.max(ans, d);
            }
        }
        return ans;
    }

    private static boolean isPossible1(int[] arr, int N, int C, int mid){
        int countCows = 1;
        int placedCow = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] >= placedCow + mid) {
                countCows++;
                placedCow = arr[i];
            }
        }
        if (countCows < C) {
            return false;
        }
        return true;
    }

    // Binary Search Approach
    // Time Complexity: O(log(max - min) * N) --> Binary search takes O(log(max - min). For every search, we iterate over max N stalls to check. Checking for N stalls takes O(N).
    // Space Complexity: O(1) --> No extra space is used.


    public static int aggressiveCows2(int[] arr, int N, int C){  // N --> stalls & C --> Cows
        Arrays.sort(arr);
        int ans = Integer.MIN_VALUE;
        int low = 1;
        int high = arr[N - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high)/2;

            if (isPossible2(arr, N, C, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossible2(int[] arr, int N, int C, int mid){
        int countCows = 1;
        int placedCow = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] >= placedCow + mid) {
                countCows++;
                placedCow = arr[i];
            }
        }
        if (countCows < C) {
            return false;
        }
        return true;
    }
}