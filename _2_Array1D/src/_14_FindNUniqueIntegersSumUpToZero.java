/*
Question: Find N Unique Integers Sum up to Zero
Given an integer n, return any array containing n unique integers such that they add up to 0.

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 */

public class _14_FindNUniqueIntegersSumUpToZero {

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n % 2 == 0){
            for(int i = 0; i < n; i+=2){
                ans[i] = i + 1;
                ans[i + 1] = -(i + 1);
            }
        }else{
            for(int i = 0; i < n-1; i+=2){
                ans[i] = i + 1;
                ans[i + 1] = -(i + 1);
            }
            ans[n-1] = 0;
        }
        return ans;
    }
}
