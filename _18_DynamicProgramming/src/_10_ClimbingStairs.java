/*
Question: Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */

import java.util.HashMap;
import java.util.Map;

public class _10_ClimbingStairs {
    // Climbing Stairs problem explain the count of the number of distinct ways to climb a staircase with n steps, where one can take 1 or 2 steps at a time.

    // 1. Recursion: Complexity : Time: O(2^n) ; Space: O(n)
    /*
    Intuition: It is a straightforward recursive solution that computes the answer by recursively computing the number of ways to climb n-1 stairs and n-2 stairs,
    and adding them up. This is an exponential solution as it will take O(2^n) time complexity in the worst case.
     */
    public int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    // 2. Recursion + Memorization (Top Down Approach) -> Complexity : Time: O(n) ; Space: O(n)
    /*
    Intuition: The second solution is a recursive solution with memoization, which is also known as the top-down approach. It stores the previously computed values
    in a map to avoid redundant computations. It has the same time complexity as the first solution, but the memoization step reduces the complexity to O(n).
     */
    public int climbStairs2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        return memo.get(n);
    }

    // 3. DP (Bottom Up Approach) -> Complexity : Time: O(n) ; Space: O(n)
    /*
    Intuition: The third solution uses dynamic programming, which is a bottom-up approach. It computes the answer iteratively by using previously computed values.
    It stores the values in an array, and at each iteration, it adds the previous two computed values to get the current value. The time complexity of this
    solution is O(n), and the space complexity is also O(n), as we need an array of size n+1 to store the values.
     */
    public int climbStairs3(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
