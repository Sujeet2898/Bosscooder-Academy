/*
LeetCode 560: Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Input: nums = [1,1,1], k = 2
Output: 2

Input: nums = [1,2,3], k = 3
Output: 2
 */

import java.util.HashMap;

public class _1_SubarraySumEqualsK {

    /*
Approach 1: Brute Force
------------------------
Algorithm: The simplest method is to consider every possible subarray of the given nums array, find the sum of the elements of each of those subarrays and check for the equality
of the sum obtained with the given k. Whenever the sum equals k, we can increment the count used to store the required result.

Time Complexity: O(n^3) --> Considering every possible subarray takes O(n^2) time. For each of the subarray we calculate the sum taking O(n) time in the worst case, taking a total of O(n^3) time.
Space Complexity: O(1) --> Constant space is used.
*/
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++){
                    sum += nums[i];
                }

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


/*
Approach 2: Using Cumulative Sum
---------------------------------
Algorithm: Instead of determining the sum of elements every time for every new subarray considered, we can make use of a cumulative sum array , sum. Then, in order to calculate
the sum of elements lying between two indices, we can subtract the cumulative sum corresponding to the two indices to obtain the sum directly, instead of iterating over the subarray to obtain the sum.
In this implementation, we make use of a cumulative sum array, sum, such that sum[i] is used to store the cumulative sum of nums array up to the element corresponding to the (i−1)th index.
Thus, to determine the sum of elements for the subarray nums[i:j], we can directly use sum[j+1]−sum[i].

Time Complexity: O(n^2) --> Considering every possible subarray takes O(n^2) time. Finding out the sum of any subarray takes O(1) time after the initial processing of O(n) for creating the cumulative sum array.
Space Complexity: O(n) --> Cumulative sum array sumsumsum of size n+1 is used.
 */

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

/*
Approach 3: Without Space
Algorithm: Instead of considering all the start and end points and then finding the sum for each subarray corresponding to those points, we can directly find the sum on the go while considering
different end points. i.e. We can choose a particular start point and while iterating over the end points, we can add the element corresponding to the end point to the sum formed till now.
Whenever the sum equals the required kkk value, we can update the count value. We do so while iterating over all the end indices possible for every start index. Whenever, we update the start index,
we need to reset the sum value to 0.

Time complexity : O(n^2) --> We need to consider every subarray possible.
Space complexity : O(1) --> Constant space is used.
 */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

/*
Approach 4: Using Hashmap
Algorithm: The idea behind this approach is as follows: If the cumulative sum (represented by sum[i] for sum up to ith index) up to two indices is the same, the sum of the elements lying in between
those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.

Based on these thoughts, we make use of a hashmap map which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs.
We store the data in the form: (sumi,no.ofoccurrencesofsumi).  We traverse over the array nums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the
hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine
the number of times the sum sum−k has occurred already, since it will determine the number of times a subarray with sum k has occurred up to the current index. We increment the count by the same amount.
After the complete array has been traversed, the count gives the required result.

Time complexity : O(n) --> The entire nums array is traversed only once.
Space complexity : O(n) --> Hashmap map can contain up to n distinct entries in the worst case.
 */

    public int subarraySum4(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

