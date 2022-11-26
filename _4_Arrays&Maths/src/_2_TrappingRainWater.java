/*
Question: Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */

public class _2_TrappingRainWater {

    // Brute force approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int trap1(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length; i++){
            int leftMax = 0;
            int rightMax = 0;

            for (int k = i; k >= 0; k--){
                leftMax = Math.max(leftMax, height[k]);
            }

            for (int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int trap2(int[] height) {
        int n = height.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // MaxHeight towards left
        maxLeft[0] = 0;
        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        // MaxHeight towards right
        maxRight[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            int waterAbove = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(waterAbove > 0){
                result += waterAbove;
            }
        }
        return result;
    }

    // 2-pointer approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int trap3(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        int lMax = 0;
        int rMax = 0;

        while(l <= r){
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);

            //why? because, for example if the lMax is smaller, we can sure that how much water could be trapped at the left pointer position is decided by the left side.
            if(lMax < rMax){
                sum += lMax - height[l];
                l++;
            }else{
                sum += rMax - height[r];
                r--;
            }
        }
        return sum;
    }
}
