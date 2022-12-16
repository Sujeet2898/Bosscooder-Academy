/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */

public class _3_SingleElementInSortedArray {

    // Using Binary Search
    // Time Complexity: O(logn)
    // Space Complexity: O(1)
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while(low <= high){
            int mid = (low + high)/2;

            if(mid % 2 == 0){
                // we are in left half so move right
                if(nums[mid] == nums[mid + 1]){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else{
                // we are in right half so move left
                if(nums[mid] == nums[mid + 1]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }
}
