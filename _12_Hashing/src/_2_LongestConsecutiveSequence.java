/*
Question: Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _2_LongestConsecutiveSequence {

    // Using Sorting
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public static int longestConsecutive1(int[] arr) {
        // Sort the given array in ascending order.
        Arrays.sort(arr);

        // To store length of longest consecutive sequence.
        int max = 0;

        // To store the length of current consecutive Sequence.
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // Check if previous value is consecutive to the current value.
            if (i > 0 && (arr[i] == arr[i - 1] + 1)) {
                count++;
            }
            // Skip if the current value is equals to the previous value.
            else if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // ReSetting count for next upcoming consecutive sequence.
            else {
                count = 1;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    // Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int longestConsecutive2(int[] nums){
        HashSet<Integer> hashset = new HashSet<>();

        // Storing all the unique elements into hashset
        for(int val : nums){
            hashset.add(val);
        }

        // variable for storing length of maximum of all consecutive sequences we get
        int longestStreak = 0;

        for(int val : nums){
            if (!hashset.contains(val - 1)){
                int currentVal = val;
                int currentStreak = 1;

                while (hashset.contains(currentVal + 1)) {
                    currentVal ++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    // Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static void longestConsecutiveSequence(int[] arr){

        HashMap<Integer, Boolean> map = new HashMap<>();

        // Assuming each value is start of sequence which is initialized with true
        for (int val : arr){
            map.put(val, true);
        }

        // value is not a start of sequence if it follows pre-smaller-value, and it should be marked with false
        for (int val : arr){
            if (map.containsKey(val - 1)){
                map.put(val, false);
            }
        }

        int maxStartPoint = 0;
        int maxLength = 0;

        // Work only for true value
        for (int val : arr) {
            if (map.get(val) == true) {
                int tempLength = 1;
                int tempStartPoint = val;

                while (map.containsKey(tempStartPoint + tempLength)) {
                    tempLength++;   // increasing sequence
                }

                // update startPoint & length
                if (tempLength > maxLength) {
                    maxStartPoint = tempStartPoint;
                    maxLength = tempLength;
                }
            }
        }

        // printing LongestConsecutiveSequence
        for (int i = 0; i < maxLength; i++){
            System.out.print(maxStartPoint + i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(longestConsecutive1(arr));
        System.out.println(longestConsecutive2(arr));
        longestConsecutiveSequence(arr);
    }
}