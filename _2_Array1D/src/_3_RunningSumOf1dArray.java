/*
Question: Running Sum of 1d Array
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

public class _3_RunningSumOf1dArray {

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int[] runningSum1(int[] nums) {
         int n = nums.length;
         int[] ans = new int[n];
         for(int i = 0; i < n; i++){
             for(int j = 0; j <= i; j++){
                 ans[i] += nums[j];
             }
         }
        return nums;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] runningSum2(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }  
}
