/*
Question: Number of Good Pairs
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */

public class _7_NumberOfGoodPairs {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int numIdenticalPairs1(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int numIdenticalPairs2(int[] nums) {
        int n = nums.length;
        int[] temp = new int[101];
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += temp[nums[i]];
            temp[nums[i]]++;
        }
        return ans;
    }
}
