/*
Question: Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Input: nums = [1], target = 0
Output: -1
 */

public class _12_SearchInRotatedSortedArray {

    // Using Linear Search
    // Time Complexity: O(N) --> We have to iterate through the entire array to check if the target is present in the array.
    // Space Complexity: O(1) --> We have not used any extra data structures

    public static int search1(int arr[],int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Using Binary Search
    // Time Complexity: O(N) --> We are performing a binary search, this turns time complexity to O(log(N)) where N is the size of the array.
    // Space Complexity: O(1) --> We have not used any extra data structures

    static int search2(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (arr[mid] == target) {
                return mid;
            }

            // left side is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && arr[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right side is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}