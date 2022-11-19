/*
Question: Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.


Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

public class _19_FindFirstAndLastPositionOfElementInSortedArray {

    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        // Finding first index
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans[0] = mid;

                // continue searching left part
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        // Finding last index
        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans[1] = mid;

                // continue searching right part
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
