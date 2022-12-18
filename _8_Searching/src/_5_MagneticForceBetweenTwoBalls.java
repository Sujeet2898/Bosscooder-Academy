/*
Question: Magnetic Force Between Two Balls
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the
minimum magnetic force between any two balls is maximum.
Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
Given the integer array position and the integer m. Return the required force.

Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.

Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.
 */

import java.util.Arrays;

public class _5_MagneticForceBetweenTwoBalls {

    // Brute Force Approach
    // Time Complexity: O((max - min) * n)
    // Space Complexity: O(1) --> No extra space is used.
    public int maxDistance1(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int maxDist = position[n - 1] - position[0];
        int ans = Integer.MIN_VALUE;

        for (int d = 1; d <= maxDist; d++) {
            boolean possible = isPossible1(position, n, m, d);
            if (possible) {
                ans = Math.max(ans, d);
            }
        }
        return ans;
    }

    private static boolean isPossible1(int[] position, int n, int m, int mid){
        int countBalls = 1;
        int placedBall = position[0];

        for (int i = 1; i < n; i++) {
            if (position[i] >= placedBall + mid) {
                placedBall = position[i];
                countBalls++;
            }
        }
        if (countBalls < m) {
            return false;
        }
        return true;
    }

    // Binary Search Approach
    // Time Complexity: O(log(max - min) * N) --> Binary search takes O(log(max - min). For every search, we iterate over max N baskets to check. Checking for N baskets takes O(N).
    // Space Complexity: O(1) --> No extra space is used.
    public int maxDistance2(int[] position, int m) {
        int n = position.length;
        int ans = Integer.MIN_VALUE;
        Arrays.sort(position);
        int low = 1;
        int high = position[n - 1] - position[0];

        while (low <= high) {
            int mid = (low + high)/2;

            if (isPossible2(position, n, m, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isPossible2(int[] position, int n, int m, int mid){
        int countBalls = 1;
        int placedBall = position[0];

        for (int i = 1; i < n; i++) {
            if (position[i] >= placedBall + mid) {
                placedBall = position[i];
                countBalls++;
            }
        }
        if (countBalls < m) {
            return false;
        }
        return true;
    }

}
