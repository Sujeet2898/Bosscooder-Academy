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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3_CoinChange {

    // Recursion:
    public int coinChange1(int[] coins, int amount) {
        if(amount<0) return -1;
        if(amount==0) return 0;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange1(coins, amount-coins[i]);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        return cc;
    }

    // Memo
    public int coinChange2(int[] coins, int amount) {
        Map<Integer,Integer> map=new HashMap<>();
        return coinChange2(coins,amount,map);
    }
    private int coinChange2(int[] coins, int amount, Map<Integer,Integer> mem ){
        if(amount<0) return -1;
        if(amount==0) return 0;
        Integer c=mem.get(amount);
        if(c!=null) return c;
        int cc=-1;
        for(int i=0;i<coins.length;i++) {
            int coin=coinChange2(coins, amount-coins[i],mem);
            if(coin>=0) cc=cc<0?coin+1:Math.min(cc,coin+1);
        }
        mem.put(amount,cc);
        return cc;
    }

    // DP
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++)
            for(int c:coins)
                if(i>=c) dp[i]=Math.min(dp[i],dp[i-c]+1);
        return dp[amount]>amount?-1:dp[amount];
    }

}
