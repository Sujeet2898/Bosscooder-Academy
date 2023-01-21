/*
Question: Capacity To Ship Packages Within D Days
A conveyor belt has packages that must be shipped from one port to another within 'days' days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
We may not load more weight than the maximum weight capacity of the ship.
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within 'days' days.

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
 */

public class _8_CapacityToShipPackagesWithinDDays {

    // Time Complexity: O(nlog(capacity)
    // Space Complexity: O(1)
    public int shipWithinDays(int[] weights, int days) {

        // to find minimum capacity bag with exactly D days so it clearly implies our bag size will be between max(weights) and sum(weights)
        int left = Integer.MIN_VALUE, right = 0;
        for(int w : weights) {
            left = Math.max(left , w);
            right += w;
        }

        while(left < right) {
            int mid = left + (right-left)/2;
            if(isShippingPossible(mid, weights, days)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    private boolean isShippingPossible(int capacity, int[] weights, int days) {
        int totalWeight = 0;
        int daysPassed = 1;
        for(int w : weights) {
            totalWeight += w;
            if(totalWeight > capacity) {
                daysPassed++;
                totalWeight = w;
                if (daysPassed > days){
                    return false;
                }
            }
        }
        return true;
    }
}
