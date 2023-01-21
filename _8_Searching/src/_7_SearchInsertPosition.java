/*
Question: Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2

Input: nums = [1,3,5,6], target = 2
Output: 1
 */

public class _7_SearchInsertPosition {

    // Time Complexity: O(logn)
    // Space Complexity: O(1)
    public int searchInsert(int[] nums, int target){
        // 1. Defining the search space
        int left = 0, right = nums.length; // right is nums.length because we have to also return the index of unfounded target to be inserted in order.

        // 2. Iterating over the search space
        while (left < right){
            int mid = left + (right - left)/2;
            if(condition(mid, nums, target)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        // return left --> the smallest possible number that satisfies the condition
        return left;
    }

    private boolean condition(int mid, int[] nums, int target) {
        return nums[mid] >= target;
    }
}













