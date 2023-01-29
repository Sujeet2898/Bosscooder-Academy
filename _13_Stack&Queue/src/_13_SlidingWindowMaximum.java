/*
Question: Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Input: nums = [1], k = 1
Output: [1]
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _13_SlidingWindowMaximum {

    // BruteForce Approach
    // Time Complexity: O(nk), where n is the length of the input array nums and k is the size of the sliding window. This is because for each window of size k, we traverse the whole window to find the maximum value, taking O(k) time. And we have n - k + 1 windows, so the total time complexity is O(nk).
    // Space Complexity: O(n), where n is the length of the input array nums. This is because we create a result array of length n - k + 1 to store the maximum value of each window, which takes O(n) space.
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        // Calculate the length of the array
        int n = nums.length;

        // Create a result array of length n - k + 1
        int[] res = new int[n - k + 1];

        // Traverse the array from left to right
        for (int i = 0; i < n - k + 1; i++) {
            // Initialize max value as the minimum possible integer value
            int max = Integer.MIN_VALUE;

            // Traverse the current window of size k
            for (int j = i; j < i + k; j++) {
                // Find the maximum value in the current window
                max = Math.max(max, nums[j]);
            }
            // Store the maximum value in the current window in the result array
            res[i] = max;
        }

        // Return the result array
        return res;
    }

    // Using DeQueue
    // Time complexity: O(n), where n is the length of the nums array. This is because we traverse the nums array once and do a constant amount of work for each element. The while loops in the solution take at most O(k) time, so the total time complexity is O(n).
    // Space complexity: O(k), because we use a deque to store the index of at most k elements. The size of the deque is limited by the size of the window, so the space complexity is O(k).
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // Create a result array of length n - k + 1
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // Create a deque to store the index of the elements
        Deque<Integer> q = new LinkedList<>();

        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            // Remove the elements from the deque that are outside the current window
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.removeFirst();
            }

            // Remove the elements from the deque that are smaller than the current element
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }

            // Add the current index to the deque
            q.addLast(i);

            // If the current window is complete, add the maximum element to the result array
            if (i >= k - 1) {
                res[i - k + 1] = nums[q.peek()];
            }
        }

        // Return the result array
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = maxSlidingWindow1(nums, k);
        // Arrays.toString(result) is a method from the java.util.Arrays class that returns a string representation of the contents of the specified array. The result is a string in the format [element1, element2, ..., elementN], where element1, element2, ..., elementN are the elements of the array.
        System.out.println(Arrays.toString(result));
    }
}

/*
Input:
8
3
1 3 -1 3 5 3 6 7
Output:
[3, 3, 5, 5, 6, 7]
 */

/*
DryRun
Let's consider an example where nums is [1,3,-1,-3,5,3,6,7] and k is 3. The steps of the optimized approach are as follows:

1. Initialize a deque q and a result array res of length n - k + 1 (in this case, 6).
2. Set i to 0, and the first window starts at 0 and ends at 2.
3. Remove the elements from the deque that are outside the current window (in this case, there are none).
4. Remove the elements from the deque that are smaller than the current element (1) (in this case, there are none).
5. Add the current index (0) to the deque. The deque now contains [0].
6. The first window is not complete, so we do not add the maximum element to the result array.
7. Set i to 1, and the current window starts at 1 and ends at 3.
8. Remove the elements from the deque that are outside the current window (in this case, 0). The deque now contains [].
9. Remove the elements from the deque that are smaller than the current element (3) (in this case, there are none).
10. Add the current index (1) to the deque. The deque now contains [1].
11. The first window is not complete, so we do not add the maximum element to the result array.
12. Set i to 2, and the current window starts at 2 and ends at 4.
13. Remove the elements from the deque that are outside the current window (in this case, 1). The deque now contains [].
14. Remove the elements from the deque that are smaller than the current element (-1) (in this case, there are none).
15. Add the current index (2) to the deque. The deque now contains [2].
16. The first window is complete, so we add the maximum element (3) to the result array at index 0. res is now [3].
17. Set i to 3, and the current window starts at 3 and ends at 5.
18. Remove the elements from the deque that are outside the current window (in this case, 2). The deque now contains [].
19. Remove the elements from the deque that are smaller than the current element (-3) (in this case, 2). The deque now contains [].
20. Add the current index (3) to the deque. The deque now contains [3].
21. The second window is complete, so we add the maximum element (3) to the result array at index 1. res is now [3, 3].
22.Repeat the steps for the remaining elements and windows, updating the deque and result array as necessary.
After all the steps are completed, the final value of res is [3, 3, 5, 5, 6, 7].
 */