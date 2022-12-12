/*
Question: Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4
 */

import java.util.HashMap;

public class _4_SingleNumber {

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
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int singleNumber2(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++)
            res = res ^ nums[i];

        return res;
    }
}
