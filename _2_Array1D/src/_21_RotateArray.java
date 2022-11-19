/*
Question: Rotate Array
Given an array, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

public class _21_RotateArray {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;       //put modulus first
        if(k < 0) {
            k = k + nums.length;
        }

        // part 1
        reverse(nums, 0, nums.length - k - 1);

        //part 2
        reverse(nums, nums.length - k, nums.length - 1);

        //all
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int li, int ri){
        while (li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;
            li++;
            ri--;
        }
    }
}
