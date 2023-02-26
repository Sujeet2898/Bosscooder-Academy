/*
Question: Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */

import java.util.*;

public class _3_TopKFrequentElements {

    // max heap, time O(n+nlogn)
    //Time complexity: O(n log n) for creating the priority queue (where n is the number of elements in the input array nums) and O(k log n) for extracting the top k elements, resulting in a total time complexity of O((n+k) log n).
    //Space complexity: O(n) for the map and O(n) for the heap, resulting in a total space complexity of O(2n), which simplifies to O(n).
    public static List<Integer> topKFrequent1(int[] nums, int k) {
        // Create a hash map to count the frequency of each number in the input array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            // If the number is already in the map, increment its frequency, otherwise set its frequency to 1
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        // Create a max heap to store map entries, sorted by frequency (from high to low)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        // Add all entries from the map to the heap
        heap.addAll(map.entrySet());

        // Create a list to store the top k frequent numbers
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            // Poll the highest frequency entry from the heap and add its key (i.e., the number) to the result list
            ret.add(heap.poll().getKey());
        }

        // Return the result list
        return ret;
    }

    // min heap, time O(n+k+(n-k)lgk)
    // Time complexity: O(n log k) for creating the priority queue (where n is the number of elements in the input array nums), as we only keep the k most frequent elements in the heap, and O(k log k) for extracting the top k elements, resulting in a total time complexity of O(n log k).
    // Space complexity: O(n) for the map and O(k) for the heap, resulting in a total space complexity of O(n + k).
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Create a hash map to count the frequency of each number in the input array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            // If the number is already in the map, increment its frequency, otherwise set its frequency to 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a min heap to store map entries, sorted by frequency (from low to high)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        // Add entries from the map to the heap, keeping only the top k frequent entries
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            heap.add(entry);
            // If the heap size exceeds k, remove the lowest frequency entry from the heap
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Create a list to store the top k frequent numbers
        List<Integer> ret = new ArrayList<>();
        while (!heap.isEmpty()) {
            // Poll the lowest frequency entry from the heap and add its key (i.e., the number) to the result list
            ret.add(heap.poll().getKey());
        }

        // Reverse the result list to get the numbers sorted by frequency (from high to low)
        Collections.reverse(ret);

        // Return the result list
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> topKFrequent = topKFrequent(nums, k);
        List<Integer> topKFrequent1 = topKFrequent1(nums, k);

        System.out.println("Using topKFrequent method:");
        System.out.println("Top " + k + " frequent elements:");
        System.out.println(topKFrequent);

        System.out.println("Using topKFrequent1 method:");
        System.out.println("Top " + k + " frequent elements:");
        System.out.println(topKFrequent1);

        // Using topKFrequent method:
        //Top 2 frequent elements:
        //[1, 2]
        // Using topKFrequent1 method:
        //Top 2 frequent elements:
        //[1, 2]
    }
}
