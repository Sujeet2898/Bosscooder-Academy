/*
Question: 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _5_FourSum {

    // Time Complexity: O(N^3.logN)  ---> [N^3.logN (3 nested loop and binary search of right half of the array)  + NlogN (sorting)]
    // Space Complexity: O(1)
    public static ArrayList<ArrayList<Integer>> fourSum1(int[] nums, int target) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        ArrayList<Integer> quad = new ArrayList();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);

                        set.add(quad);
                        left++;
                        right--;
                    } else if(sum < target) {
                        left++;
                    } else if(sum > target) {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public static ArrayList<ArrayList<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(nums == null || nums.length == 0){ // null case and empty array
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){

                int target_2 = target - nums[j] - nums[i];

                // j + 1 to n - 1
                int front = j + 1;
                int back = n - 1;

                while(front < back){
                    int two_sum = nums[front] + nums[back];

                    if(two_sum < target_2){
                        front++;
                    }else if(two_sum > target_2){
                        back--;
                    }else{

                        ArrayList<Integer> quad = new ArrayList();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);

                        result.add(quad);

                        // processing the duplicates of number 3
                        while(front < back && nums[front] == quad.get(2)){
                            front++;
                        }
                        // processing the duplicates of number 4
                        while(front < back && nums[back] == quad.get(3)){
                            back--;
                        }
                    }
                    // processing the duplicates of number 2
                    while(j + 1 < n && nums[j + 1] == nums[j]){
                        j++;
                    }
                }
                // processing the duplicates of number 1
                while(i + 1 < n && nums[i + 1] == nums[i]){
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        // ArrayList<ArrayList<Integer>> output = fourSum2(a, target);
        ArrayList<ArrayList<Integer>> output = fourSum1(a, target);
        for(int i = 0; i < output.size(); i++) {
            for(int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}