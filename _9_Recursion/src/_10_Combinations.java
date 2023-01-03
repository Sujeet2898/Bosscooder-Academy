/*
Question: Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */

import java.util.ArrayList;
import java.util.List;

public class _10_Combinations {

    // Recursive (Backtracking) Approach
    // Time Complexity: O(n * 2^n) -> O(N×2^N) to generate all subsets and then copy them into output list.
    // Space Complexity: O(n) --> Same list is modified again and again; firstly list is add, then move till depth, remove all the number, then again pick the another branch
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsets = new ArrayList();
        generateSubSet(1, n, new ArrayList(), subsets, k);
        return subsets;
    }
    void generateSubSet(int start, int n, List<Integer> current, List<List<Integer>> subsets, int k){
        if (current.size() == k){
            subsets.add(new ArrayList(current)); // []
            return;
        }

        for (int i = start; i <= n; i++){
            current.add(i); // [1]
            generateSubSet(i + 1, n, current, subsets, k);  // ----move till depth
            current.remove(current.size()-1);  // []
        }
    }
}
