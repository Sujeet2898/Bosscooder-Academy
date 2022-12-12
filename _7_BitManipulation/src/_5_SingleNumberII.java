/*
Question: Single Number II
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Input: nums = [2,2,3,2]
Output: 3

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */

import java.util.HashMap;

public class _5_SingleNumberII {

    // Using HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int singleNumber1(int[] nums) {
        int n = nums.length;
        int result = -1;
        HashMap<Integer,Integer> map = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if (map.get(nums[i]) == 1) {
                result = nums[i];
                break;
            }
        }

        return result;
    }

    // Using Bit Manipulation
    // Time Complexity: O(32 * n)
    // Space Complexity: O(1)
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if((nums[j] & (1<<i)) != 0)
                    count++;
            }
            if(count % 3 != 0)
                ans |= 1<<i;
        }
        return ans;
    }
}
