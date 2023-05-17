/*
Question: Split Array Largest Sum
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.  

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */

public class _11_SplitArrayLargestSum {

    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int splitArray(int[] nums, int k){
        // 1. Defining the search space
        int left = Integer.MIN_VALUE, right = 0;
        for(int w : nums) {
            left = Math.max(left , w);
            right += w;
        }
        // 2. Iterating over the search space
        while (left < right){
            int mid = left + (right - left)/2;
            if(feasible(nums, mid, k)){
                right = mid;  
            }
            else {
                left = mid + 1;
            }
        }

        // return left --> the smallest possible number that satisfies the condition
        return left;
    }

    private boolean feasible(int[] nums, int mid, int k) {
        int sum = 0;
        int part = 1;
        for(int val : nums){
            sum += val;
            if (sum > mid){
                sum = val;
                part++;
                if (part > k){
                    return false;
                }
            }
        }
        return true;
    }
}
