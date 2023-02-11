/*
Question: Maximizing XOR
Given two integers, l and r, find the maximal value of a xor b, written a^b, where a and b satisfy the following condition:
l <= a <= b <= r
For example, if i = 11 and r = 12, then
11^11 = 0
11^12 = 7
12^12 = 0
Our maximum value is 7.
Function Description:
Complete the maximizingXor function in the editor below. It must return an integer representing the maximum value calculated.
maximizingXor has the following parameter(s):
* l: an integer, the lower bound, inclusive
* r: an integer, the upper bound, inclusive
Input Format:
The first line contains the integer l.
The second line contains the integer r.
Constraints
1 <= l <= r <= 1000
Output Format
Return the maximal value of the xor operations for all permutations of the integers from l to r, inclusive.
Sample Input
10
15
Sample Output
7
Explanation
Here l = 10 and r = 15. Testing all pairs:
10^10 = 0
10^11 = 1
10^12 = 6
10^13 = 7
10^14 = 4
10^15 = 5
11^11 = 0
11^12 = 7
11^13 = 6
11^14 = 5
11^15 = 4
12^12 = 0
12^13 = 1
12^14 = 2
12^15 = 3
13^13 = 0
13^14 = 3
13^15 = 2
14^14 = 0
14^15 = 1
15^15 = 0
Two pairs, (10, 13) and (11, 12) have the xor value 7, and this is maximal.
Sample Input 1
11
100
Sample Output 1
127
 */


public class _2_MaximizingXOR {

    // Time complexity: O(n^2), where n = (r - l + 1). This is because for each value of i from l to r, we have to loop through all values of j from i to r, which gives us a total of n * (n + 1) / 2 iterations. This results in a quadratic time complexity.
    // Space complexity: O(1), as we only use a constant amount of memory regardless of the size of the input. The variables max, i, and j only use a constant amount of memory, so the space complexity is constant.
    public static int maximizingXor(int l, int r) {
        // Initialize max to the lowest possible integer value
        int max = Integer.MIN_VALUE;

        // Loop through all values from l to r (inclusive)
        for (int i = l; i <= r; i++) {
            // Loop through all values from i to r (inclusive)
            for (int j = i; j <= r; j++) {
                // Calculate the xor of i and j
                int xor = i ^ j;
                // Update the max if the xor is greater than the current max
                max = Math.max(max, xor);
            }
        }
        // Return the final max
        return max;
    }

    public static void main(String[] args) {
        int l = 11;
        int r = 12;
        int result = maximizingXor(l, r);
        System.out.println(result);  // 7
    }

}
