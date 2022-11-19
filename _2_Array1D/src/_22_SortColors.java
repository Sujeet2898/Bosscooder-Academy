/*
Question: Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */

public class _22_SortColors {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length-1;
        while(i <= k){
            if(nums[i] == 0){
                swap(nums, i, j);
                i++;
                j++;
            }else if(nums[i] == 1){
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, k);
                k--;
            }
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
