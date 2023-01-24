/*
LeetCode 209: Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Input: target = 4, nums = [1,4,4]
Output: 1

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */
public class _2_MinimumSizeSubarraySum {

/*
Approach #1 Brute force [Time Limit Exceeded]
-----------------------------------------------
Intuition: Do as directed in question. Find the sum for all the possible subarrays and update the ans as and when we get a better subarray that fulfill the requirements (sum≥s).

Algorithm:
Initialize ans=INT_MAX
Iterate the array from left to right using i:
Iterate from the current element to the end of array using j:
Find the sum of elements from index i to j
If sum is greater then s: Update ans=min(ans,(j−i+1)) and Start the next ith iteration, since, we got the smallest subarray with sum≥s starting from the current index.

Time complexity: O(n^3) --> For each element of array, we find all the subarrays starting from that index which is O(n^2). Time complexity to find the sum of each subarray is O(n). Thus, the total time complexity : O(n2∗n) = O(n^3)
Space complexity: O(1) extra space.

 */

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

/*
Approach #2 A better brute force [Accepted]
----------------------------------------------
Intuition: In Approach #1, you may notice that the sum is calculated for every surarray in O(n) time. But, we could easily find the sum in O(1) time by storing
the cumulative sum from the beginning(Memoization). After we have stored the cumulative sum in sums, we could easily find the sum of any subarray from i to j.

Algorithm:
The algorithm is similar to Approach #1.
The only difference is in the way of finding the sum of subarrays:
Create a array sums of size of nums
Initialize sums[0]=nums[0]
Iterate over the sums vector:
Update sums[i]=sums[i−1]+nums[i]
Sum of subarray from i to j is calculated as: sum=sums[j]−sums[i]+nums[i] , wherein sums[j]−sums[i] is the sum from (i+1)th element to the jth element.

Time complexity: O(n^2) --> Time complexity to find all the subarrays is O(n^2). Sum of the subarrays is calculated in O(1) time. Thus, the total time complexity: O(n^2 * 1) = O(n^2)
Space complexity: O(n) extra space. Additional O(n) space for sums array than in Approach #1.
 */

    public int minSubArrayLen2(int s, int[] nums){
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

/*
Approach #4 Using 2 pointers
-----------------------------
Intuition: Until now, we have kept the starting index of subarray fixed, and found the last position. Instead, we could move the starting index of the current
subarray as soon as we know that no better could be done with this index as the starting index. We could keep 2 pointer,one for the start and another for the
end of the current subarray, and make optimal moves so as to keep the sum greater than sss as well as maintain the lowest size possible.
Algorithm:
Initialize left pointer to 0 and sum to 0
Iterate over the nums:
Add nums[i] to sum
While sum is greater than or equal to s:
Update ans=min(ans,i+1−left), where i+1−left is the size of current subarray
It means that the first index can safely be incremented, since, the minimum subarray starting with this index with sum≥s has been achieved
Subtract nums[left] from sum\text{sum}sum and increment left

Time complexity: O(n) --> Single iteration of O(n). Each element can be visited atmost twice, once by the right pointer(i) and (atmost)once by the left pointer.
Space complexity: O(1) extra space. Only constant space required for left, sum, ans and i.
 */

    public int minSubArrayLen4(int s, int[] nums){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
