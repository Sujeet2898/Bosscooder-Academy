/*
Question: Buy And Sell Stocks - One Transaction Allowed
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */

import java.util.Scanner;

public class _7_OneTransaction {

    // Time Complexity: O(N) --> Where N is the size of prices array.
    // Space Complexity: O(1) --> We do not use any extra space.

    public static int getMaximumProfit1 (int[] prices){

        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i ++){
            if (prices[i] < leastSoFar){
                leastSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - leastSoFar;

            if (profitIfSoldToday > overAllProfit){
                overAllProfit = profitIfSoldToday;
            }
        }
        return overAllProfit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit1(prices));
    }
}
