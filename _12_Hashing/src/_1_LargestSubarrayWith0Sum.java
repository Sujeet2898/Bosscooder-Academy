/*
Question: Largest subarray with 0 sum
Given an array having both positive and negative integers. The task is to compute
the length of the largest subarray with sum 0.
Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
 */

import java.util.HashMap;

public class _1_LargestSubarrayWith0Sum {

    // Using Brute Force (Naive approach)
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)

    public static int lengthOfLongestSubsetWithZeroSum1(int arr[]){
        // Initialize result
        int maxLen = 0;

        // Pick a starting point
        for (int i = 0; i < arr.length; i++) {

            // Initialize currSum for every starting point
            int currSum = 0;

            // Try all subarrays starting with 'i'
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];

                // If currSum becomes 0,then update maxLen if required

                if (currSum == 0)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    public static int lengthOfLongestSubsetWithZeroSum2(int arr[]){

        // HashMap contains sum and index of array
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int sum = 0;
        int i = -1;

        // Put zero-sum at -1 index i.e before arrayIndex
        map.put(sum, i);

        while (i < arr.length - 1){
            i++;
            sum += arr[i];

            // false means first time occurrence of sum at index
            if (map.containsKey(sum) == false){
                map.put(sum, i);
            }else{
                // If again same sum is found, we have to calculate length between them for knowing zero sum length
                // length = present index of sum - previous same index of sum
                int length = i - map.get(sum);

                if (length > maxLength){
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        System.out.println(lengthOfLongestSubsetWithZeroSum1(arr));
        System.out.println(lengthOfLongestSubsetWithZeroSum2(arr));
    }
}