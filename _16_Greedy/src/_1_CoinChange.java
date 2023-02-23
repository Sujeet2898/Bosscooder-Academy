/*
Question: Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.


Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Input: coins = [2], amount = 3
Output: -1

Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class _1_CoinChange {

    // Using BFS
    // Time complexity: O(S * n), where S is the amount and n is the number of coins. This is because we iterate through the amount S once and for each value we iterate through all n coins. Within each iteration, we perform constant time operations like adding and removing elements from the queue and checking if an element is in the set, so the overall time complexity is O(S * n).
    // Space complexity: O(S), where S is the amount. This is because we create a Deque and a Set with at most S elements. The Deque and the Set both store the same values, so the overall space complexity is dominated by the larger of the two, which is the Set. Therefore, the space complexity is O(S).

    public static int coinChange(int[] coins, int amount) {
        // If coins is null or empty, or amount is less than 1, return 0
        if (coins == null || coins.length == 0 || amount < 1) return 0;

        // Create a Deque (double-ended queue) called queue and a Set called visited
        Deque<Integer> queue = new ArrayDeque<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();

        // Add the value of amount to the front of the queue and add amount to visited
        queue.addFirst(amount);
        visited.add(amount);

        // Initialize a variable called level to 0
        int level = 0;

       // While the queue is not empty
        while (!queue.isEmpty()) {
            // Get the current size of the queue
            int size = queue.size();

            // Loop through each index of the queue
            while (size-- > 0) {
                // Remove and store the last element in the queue as curr
                int curr = queue.removeLast();
                // If curr equals 0, return the current level
                if (curr == 0) return level;

                // If curr is negative, continue to the next iteration of the loop
                if (curr < 0) continue;

                // Loop through each coin in coins
                for (int coin : coins) {
                    // Calculate the next value by subtracting the current coin from curr
                    int next = curr - coin;
                    // If next is greater than or equal to 0 and has not been visited before
                    if (next >= 0 && !visited.contains(next)) {
                        // Add next to the front of the queue and add next to visited
                        queue.addFirst(next);
                        visited.add(next);
                    }
                }
            }

            // Increment the level
            level++;
        }

        // If no solution is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int numCoins = coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + numCoins);
        // Minimum number of coins needed: 3
    }
}
