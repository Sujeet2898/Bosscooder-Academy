/*
Question: Buy And Sell Stocks - Two Transactions Allowed
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

import java.util.Arrays;

public class _8_TwoTransaction {

    // Recursion
    public static int maxProfitUtil(int idx, int buy, int[] prices) {
       //base condition//
        if(idx== prices.length) return 0;
        int profit = 0;
        if(buy == 0){
            profit = Math.max((0 + maxProfitUtil(idx+1, 8, prices)), (-prices [idx]+ maxProfitUtil(idx+1, 1, prices)));
        }
        if (buy == 1) {
            profit = Math.max((0 + maxProfitUtil(idx + 1, 1, prices)), (prices[idx] + maxProfitUtil(idx + 1, 0, prices)));
        }
        return profit;
    }
    public int maxProfit1(int[] prices) {
        return maxProfitUtil(0, 0, prices);
    }

    // Memoization
    public static int maxProfitUtil(int idx, int buy, int[] prices, int[][] dp) {
        //base condition//
        if (idx == prices.length) return 0;

        if (dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        if (buy == 0) {
            profit = Math.max((0 + maxProfitUtil(idx + 1, 0, prices, dp)), (-prices[idx] + maxProfitUtil(idx + 1, 1, prices, dp)));
        }

        if (buy == 1) {
            profit = Math.max((0 + maxProfitUtil(idx + 1, 1, prices, dp)), (prices[idx] + maxProfitUtil(idx + 1, 0, prices, dp)));
        }
        dp[idx][buy] = profit;

        return dp[idx][buy];
    }
    public int maxProfit2 (int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return maxProfitUtil(0, 0, prices, dp);
    }

    // Dp
    public int maxProfit3 (int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        int profit = 0;
        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }
        //base condition//
        dp[n][0] = dp[n][1] = 0;
        for (int idx = n - 1; idx > 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max((0 + dp[idx + 1][0]), (-prices[idx] + dp[idx + 1][1]));
                }
                if (buy == 1) {
                    profit = Math.max((0 + dp[idx + 1][1]), (prices[idx] + dp[idx + 1][0]));
                }
                dp[idx][buy] = profit;
            }

        }
        return dp[0][0];
    }
}
