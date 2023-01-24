/*
Question: Merge Sorted Array
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing
the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */

import java.util.Arrays;

public class _6_MergeTwoSortedArrays {

    // Time Complexity: O(N)
    // Space Complexity: O(N)

    public static int[] mergeTwoSortedArrays1(int arr1[], int arr2[], int m, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                result[k] = arr1[i];
                i++;
                k++;
            }else{
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i < m){
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j < n){
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)    

    public void mergeTwoSortedArrays2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i > -1 && j > -1){
            // traversing from end and picking greater element of 2 arrays
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }else{
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }

        while(i > -1){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j > -1){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}