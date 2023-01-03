/*
Question: Subsets
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */

import java.util.ArrayList;
import java.util.List;

public class _9_Subsets {

    // Brute Force Approach
    // Time Complexity: O(n * 2^n) -> O(N×2^N) to generate all subsets and then copy them into output list.
    // Space Complexity: O(n * 2^n) -> This is exactly the number of solutions for subsets multiplied by the number NNN of elements to keep for each subset.
    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<>());

        for(int val : nums){  // n size;  nums = {1, 2, 3}
            int n = result.size();
            for(int j = 0; j < n; j++){   // 2^n size
                List<Integer> temp = new ArrayList<>(result.get(j));  // []
                temp.add(val); // [1]
                result.add(temp); // [][1]
            }
        }

        return result;
    }

    // Recursive (Backtracking) Approach
    // Time Complexity: O(n * 2^n) -> O(N×2^N) to generate all subsets and then copy them into output list.
    // Space Complexity: O(n) --> Same list is modified again and again; firstly list is add, then move till depth, remove all the number, then again pick the another branch
    //                            We are using O(N) space to maintain curr, and are modifying curr in-place with backtracking. Note that for space complexity analysis, we do not count space that is only used for the purpose of returning output, so the output array is ignored.
    //                    Or
    //                   O(n * 2^n) --> 2^n subsets are generated and each subset is saved and size of each subset is n
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        generateSubSet(0, nums, new ArrayList(), result);
        return result;
    }
    void generateSubSet(int index, int[] nums, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList(current)); // []  ; coping for updating the current

        for (int i = index; i < nums.length; i++){
            current.add(nums[i]); // [1]  ; add number
            generateSubSet(i + 1, nums, current, result);  // ----move till depth
            current.remove(current.size()-1);  // []  ; remove all the number
        }
    }

    // Bit Manipulation Approach
    // Time Complexity: O(n * 2^n) ->  O(N×2N) to generate all subsets and then copy them into output list.
    // Space Complexity: O(n * 2^n) -> O(N×2^N) to keep all the subsets of length NNN, since each of NNN elements could be present or absent.
    public List<List<Integer>> subsets3(int[] nums){
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;  // nums = [1, 2, 3]

        for(int i = 0; i < (1<<n); i++){  // n = 3 -> 2^3 = 8  Here, (1<<n) is same as 2^n
            List<Integer> current = new ArrayList<>();

            // let for i = 5 -> 101 -> [1,3]
            for(int j = 0; j < n; j++){
                // checking bit is set or not
                if(((1<<j)&i) != 0){
                    // for j = 0 -> 1 & 101 = 001 -> bit is set, so add 1 in current
                    // for j = 1 -> 10 & 101 = 000 -> bit is off, so don't add 2 in current
                    // for j = 2 -> 100 & 101 = 100 -> bit is set, so add 3 in current
                    current.add(nums[j]);  // [1,3]
                }
            }
            result.add(current);
        }
        return result;
    }
}
