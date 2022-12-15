/*
Question: Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements or duplicate elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 */

public class _2_FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        // If the list has just one element then return that element.
        if (nums.length == 1) {
            return nums[0];
        }

        // Initializing low and high pointers.
        int low = 0, high = nums.length - 1;

        // If the last element is greater than the first element then there is no rotation or rotated n times. e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array. Hence the smallest element is first element. A[0]
        if (nums[high] > nums[0]) {
            return nums[0];
        }

        // Binary search
        while (low <= high) {
            // Find the mid element
            int mid = low + (high - low) / 2;

            // We stop our search when we find the inflection point, when either of the two conditions is satisfied:

            // Condition 1: nums[mid] > nums[mid + 1] Hence, mid+1 is the smallest.
             if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Condition 2: nums[mid - 1] > nums[mid] Hence, mid is the smallest.
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // If mid element > first element of array this means that we need to look for the inflection point on the high of mid.
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            }

            // If mid element < first element of array this means that we need to look for the inflection point on the low of mid
            if (nums[mid] < nums[0]) {
                high = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
