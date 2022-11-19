/*
Question: Find Numbers with Even Number of Digits
Given an array nums of integers, return how many of them contain an even number of digits.

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
 */

public class _11_FindNumbersWithEvenNumberOfDigits {

    // Time Complexity: O(n) --> we are traversing the array along with finding digitCount and each number in array is O(length of that number)
    // Space Complexity: O(1)
    public int findNumbers1(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int digitCount = 0;
            while(nums[i] > 0){
                digitCount++;
                nums[i] /= 10;
            }
            if(digitCount % 2 == 0){
                ans++;
            }
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int findNumbers2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int digitCount = (int) Math.log10(nums[i]) + 1;  // direct digit count
            if(digitCount % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
}
