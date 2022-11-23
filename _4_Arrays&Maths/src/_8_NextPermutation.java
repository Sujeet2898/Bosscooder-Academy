/*
Question: Next Permutation
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible,
the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
 */

public class _8_NextPermutation {

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // e.g [1,5,2,4,3,2]

        int left = nums.length - 2; // The array is zero-indexed, so the largest index is nums.length - 1. But we need to reserve the last index for the most right digit, it makes the most left index nums.length - 2.

        // from right to left, search for the first one which is smaller than the right digit.
        // 1 5 (2) 4 3 2
        while (left >= 0 && nums[left] >= nums[left + 1]) { // so, decrease the left as long as 2, 3, 4 (right digit) is greater or equal to (2)
            left--;
        }

        // If the one exists, search a one which is just larger than it (i.e 2) from right to left.
        // 1 5 (2) 4 (3) 2
        if (left >= 0) {  // to avoid index -1 out of bounds for length 3

            int right = nums.length - 1;
            while (right >= 0 && nums[left] >= nums[right]) { // so, decrease the right as long as left (i.e 2) is greater or equal to 2, 3, 4 (right digit)
                right--;
            }
            // swap them
            swap(nums, left, right);
        }

        // flip the right to make the number smaller.
        reverse(nums, left + 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int low) {
        int left = low;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
