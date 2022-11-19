/*
Question: Maximum Subarray
Given an integer array nums, find the subarray which has the largest sum and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class _15_MaximumSubarray {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int overallSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(currentSum >= 0){
                currentSum += nums[i];
            }else{
                currentSum = nums[i];
            }

            if(currentSum > overallSum){
                overallSum = currentSum;
            }
        }
        return overallSum;
    }
}
