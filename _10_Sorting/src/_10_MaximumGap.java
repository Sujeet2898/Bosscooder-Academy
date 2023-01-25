/*
Question: Maximum Gap
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
You must write an algorithm that runs in linear time and uses linear extra space.
Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
 */

import java.util.Arrays;

public class _10_MaximumGap {

    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int maximumGap1(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i <nums.length ; i++) {
            int temp = nums[i] - nums[i-1];
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maximumGap(int[] nums) {
/* Idea : We will use Bucked sort to solve this question.
          We have to first define the intervals, We will use the min and max to find the total number of intervals needed.
          Now, we need the min and max value of each averageGap, so we  can compare it with the previous bucket.
          In the end we will traverse from the min to the max and then check the elements in each buckets.
          To assign a bucket to each element, we will use : nums[i] - min / no_of_intervals.
          no_of_intervals = Math.ceil((max-min)/ nums.length-1).
          And finally we will use the max element to check if difference between the final element and the final bucket is the answer.
        */

        int n = nums.length;

        // Base Case :
        if(n < 2){
            return 0;
        }

        int min = nums[0];
        int max = nums[0];

        for(int val : nums){                // for(int i = 0; i < n; i++){
            min = Math.min(min, val);       //     min = Math.min(min, nums[i]);
            max = Math.max(max, val);       //     max = Math.max(max, nums[i]);
        }                                   // }

        int averageGap = (int)Math.ceil((double)(max - min)/(n-1));

        // to handle if all the numbers are same
        if(averageGap == 0){
            return 0;
        }

        int[] minOfBucket = new int[n-1];
        int[] maxOfBucket = new int[n-1];

        // Allocate the numbers to their respective buckets
        Arrays.fill(minOfBucket, Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, -1);

        // Set the min and max of bucket.
        for(int i = 0; i < n; i++){
            if(nums[i] == min || nums[i] == max){
                continue;
            }

            int bucketNumber = (nums[i] - min) / averageGap;
            minOfBucket[bucketNumber] = Math.min(minOfBucket[bucketNumber], nums[i]);
            maxOfBucket[bucketNumber] = Math.max(maxOfBucket[bucketNumber], nums[i]);
        }

        // Just compare the consecutive bucket numbers
        // Now we will use min to see the maximum of previous bucket.
        int ans = 0;
        for(int i = 0; i < n-1; i++){
            if(maxOfBucket[i] == -1) {
                continue;
            }
            ans = Math.max(ans, minOfBucket[i] - min);
            min = maxOfBucket[i];
        }

        ans = Math.max(ans, max - min);
        return ans;
    }
}