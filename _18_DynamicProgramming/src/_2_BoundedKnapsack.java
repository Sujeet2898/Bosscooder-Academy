/*
Question: 0/1 Knapsack Problem
We are given N items where each item has some weight and profit associated with it. We are also given a bag with capacity W, [i.e., the bag can hold at most W weight in it].
The target is to put the items into the bag such that the sum of profits associated with them is the maximum possible.

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0
 */

/*
kisin knapsacks & Tec
if(wt[idx] <= W) return val [idx];
else return 0;
}
int notTake = 0 + knapsack(idx: idx - 1, W, wt, val);
int take Integer.MINVALUE; =
if(wt[idx] <<W) { C
take val[idx] + knapsack(idx: idx - 1, W: W - wt[idx], wt, val);
return Math.max(notTake, take);

public static void main(String[

int val (30,40,60);
Intoper HD VALUE int wt- (3,2,5); }
int W-6;
System.out.println(knapsack(id: wt. Length-1, W. wt, val));
 */

public class _2_BoundedKnapsack {

    public static int knapsackRecursion(int idx, int W, int[] wt, int[] val){

        if(idx == 0) {
            if (wt[idx] <= W) return val[idx];
            else return 0;
        }

        int notTake = 0 + knapsackRecursion(idx - 1, W, wt, val);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= W) {
            take = val[idx] + knapsackRecursion(idx - 1, W - wt[idx], wt, val);
        }
        return Math.max(notTake, take);
    }

    public static int knapsackMemo(int idx, int W, int[] wt, int[] val, int[][] dp){

        if(idx == 0) {
            if (wt[idx] <= W) return val[idx];
            else return 0;
        }

        if(dp[idx][W] != -1){
            return dp[idx][W];
        }

        int notTake = 0 + knapsackRecursion(idx - 1, W, wt, val);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= W) {
            take = val[idx] + knapsackRecursion(idx - 1, W - wt[idx], wt, val);
        }

        dp[idx][W] = Math.max(notTake, take);
        return dp[idx][W];
    }

    public static void main(String[] args) {
        int[] wt = {3,2,5};
        int[] val = {30,40,60};
        int W = 6;
        System.out.println(knapsackRecursion(wt.length-1, W, wt, val)); // 70
    }
}
