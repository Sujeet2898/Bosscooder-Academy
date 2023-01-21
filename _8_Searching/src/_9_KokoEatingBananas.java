/*
Question: Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Input: piles = [3,6,7,11], h = 8
Output: 4

Input: piles = [30,11,23,4,20], h = 5
Output: 30
 */

public class _9_KokoEatingBananas {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        // 1. Defining the search space
        int left = 1, right = 0;
        for(int val : piles) {
            right = Math.max(right , val);
        }
        // 2. Iterating over the search space
        while (left < right){
            int mid = left + (right - left)/2;
            if(canFinishPile(mid, piles, h)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        // return left --> the smallest possible number that satisfies the condition
        return left;
    }

    private boolean canFinishPile(int rate, int[] piles, int h) {
        int hourPassed = 0;
        for(int pile : piles){
            hourPassed += (pile / rate);
            if(pile % rate > 0){
                hourPassed++;
            }
        }
        return hourPassed <= h;
    }
}
