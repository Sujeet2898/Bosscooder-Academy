/*
Question: Shuffle the Array
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 */

public class _5_ShuffleTheArray {

    // Brute Force Approach:
    // Time Complexity: O(2*n) = O(n)
    // Space Complexity: O(2*n) = O(n)
    public int[] shuffle1(int[] nums, int n) {
        int[] ans = new int[2*n];
        int j = 0;
        for(int i = 0; i < 2*n; i+=2){
            ans[i] = nums[j];
            ans[i+1] = nums[j+n];
            j++;
        }
        return ans;
    }

    // Optimized Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // nums = [2,5,1,3,4,7], n = 3 ; 1 <= nums[i] <= 10^3
    public int[] shuffle2(int[] nums, int n){
        for(int i = 0; i < n; i++){
            // nums = [2,5,1, 2*10001+3, 5*10001+4, 1*10001+7]
            nums[i+n] = nums[i+n] + nums[i]*10001;
        }
        for(int i = 0; i < n; i++){
            nums[2*i] = nums[i+n] / 10001;   // 20005 / 10001 = 2
            nums[2*i + 1] = nums[i+n] % 10001;  // 20005 % 10001 = 3
        }
        return nums;
    }

    // Bitwise Approach:
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // nums = [2,5,1,3,4,7], n = 3
    public int[] shuffle3(int[] nums, int n){
        for(int i = 0; i < n; i++){
            nums[i+n] = (nums[i+n] << 10) | nums[i];
        }
        for(int i = 0; i < n; i++){
            int n1 = nums[i+n] & 1023;  // 2
            int n2 = nums[i+n] >> 10;   // 3
            nums[2*i] = n1;
            nums[2*i + 1] = n2;
        }
        return nums;
    }

}
