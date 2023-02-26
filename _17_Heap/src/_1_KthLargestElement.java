/*
Question: Kth Largest Element
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
You must solve it in O(n) time complexity.

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */

import java.util.PriorityQueue;

public class _1_KthLargestElement {

    // One method is you can sort the elements then find "arr.length-k"th element here Time O(nlogn) for best sort +no extra space
    //or you can you PriorityQueue -Time =O(nlogn) and Space =O(k) (size of priority queue or k elements)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i =0;i<nums.length;i++){
            if(pq.size()<k){
                pq.add(nums[i]);
            }
            else{
                if(pq.peek()<nums[i]){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }

}

