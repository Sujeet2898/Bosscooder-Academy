/*
Question: 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class _4_ThreeSum {

    // 1. Brute Force Approach
    // Time Complexity: O(N^3)  --> 3 loops
    // Space Complexity: O(1) --> O(3 * k) where k is the no.of triplets

    static ArrayList<ArrayList<Integer>> threeSum1(int nums[]) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }
        return ans;
    }

    // Optimized Approach
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)

    public ArrayList<ArrayList<Integer>> threeSum2(int[] nums) {
        int target = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i<=nums.length-1 ;i++){

            int remaining  = target - nums[i] ;

            // i + 1 to n - 1
            int front = i + 1;
            int back = nums.length - 1;

            while(front < back){
                int twoSum = nums[front] + nums[back];

                if(twoSum < remaining){
                    front++;
                }
                else if(twoSum > remaining){
                    back--;
                }
                else{
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[front]);
                    triplet.add(nums[back]);

                    result.add(triplet);

                    // processing the duplicates of number 2
                    while(front < back && nums[front] == triplet.get(1)){
                        front++;
                    }
                    // processing the duplicates of number 3
                    while(front < back && nums[back] == triplet.get(2)){
                        back--;
                    }
                }
            }
            // processing the duplicates of number 1
            while( i + 1 <= nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return result;
    }
}