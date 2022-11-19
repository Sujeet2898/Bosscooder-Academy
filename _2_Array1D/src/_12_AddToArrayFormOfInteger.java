/*
Question: Add to Array-Form of Integer
The array-form of an integer num is an array representing its digits in left to right order.
For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _12_AddToArrayFormOfInteger {

    // Time Complexity: O(max(n, logk)
    // Space Complexity: O(max(n, logk)
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;
        while(i >= 0 || k > 0){
            if(i >= 0){
                ans.add((num[i] + k) % 10);
                k = (num[i] + k) / 10;
            }else{
                ans.add(k % 10);
                k = k / 10;
            }
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
