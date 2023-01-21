/*
Question: Minimum Number of Days to Make m Bouquets
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 */

public class _10_MinimumNumberOfDaysToMakeMBouquets {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length / k < m){
            return -1;
        }

        // 1. Defining the search space
        int left = 1, right = 0;
        for(int val : bloomDay) {
            right = Math.max(right , val);
        }
        // 2. Iterating over the search space
        while (left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(bloomDay, m, k, mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        // return left --> the smallest possible number that satisfies the condition
        return left;
    }

    private boolean isFeasible(int[] bloomDay, int m, int k, int allowedDays) {
        int bouquets = 0, flowers = 0;
        for(int bloom : bloomDay){
            if(bloom > allowedDays){
                flowers = 0;
            }else {
                bouquets += (flowers + 1)/k;
                flowers = (flowers + 1)%k;
            }
        }
        return bouquets >= m;
    }
}