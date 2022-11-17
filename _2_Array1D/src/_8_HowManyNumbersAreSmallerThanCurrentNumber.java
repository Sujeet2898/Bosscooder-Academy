/*
Question: How Many Numbers Are Smaller Than the Current Number
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */

public class _8_HowManyNumbersAreSmallerThanCurrentNumber {

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] temp = new int[101];  // 0 <= nums[i] <= 100

        // Storing frequency
        for(int i = 0; i < n; i++){
            temp[nums[i]]++;
        }

        // Running sum
        for(int i = 1; i < 101; i++){
            temp[i] += temp[i-1];
        }

        // Storing ans
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                ans[i] = 0;
            }else{
                ans[i] = temp[nums[i] - 1];
            }
        }

        return ans;
    }
}
