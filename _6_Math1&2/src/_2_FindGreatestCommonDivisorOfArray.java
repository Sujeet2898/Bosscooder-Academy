public class _2_FindGreatestCommonDivisorOfArray {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int val : nums){
            max = Math.max(max,val);
            min = Math.min(min,val);
        }
        return gcd(max,min);
    }
    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        if(a < b){
            return gcd(b,a);
        }
        return gcd(a % b,b);
    }
}
