/*
Question: Lonely Integer
Given an array of integers, where all elements but one occur twice, find the unique element.
Example:
a = [1, 2, 3, 4, 3, 2, 1]
The unique element is 4.
Function Description:
Complete the lonelyinteger function in the editor below.
lonelyinteger has the following parameter(s):
* int a[n]: an array of integers
Returns:
* int: the element that occurs only once
Input Format:
The first line contains a single integer, n, the number of integers in the array.
The second line contains  space-separated integers that describe the values in a.
Constraints:
* 1 <= n < 100
* It is guaranteed that  is an odd number and that there is one unique element.
* 0 <= a[i] <= 100, where 0 <= i < n.
Sample Input
1
1
Sample Output
1
Explanation
There is only one element in the array, thus it is unique.
Sample Input 1
3
1 1 2
Sample Output 1
2
Explanation 1
We have two 's, and  is unique.
Sample Input 2
5
0 0 1 2 1
Sample Output 2
2
Explanation 2
We have two 0's, two 1's, and one 2. 2 is unique.
 */

import java.util.Arrays;
import java.util.List;
public class _1_LonelyInteger {

    // Time complexity: O(n), where n is the number of elements in the list. This is because we loop through all elements in the list exactly once.
    // Space complexity: O(1), because we only use a single integer variable to store the result, regardless of the size of the input list. This means that the amount of memory used by the algorithm remains constant, regardless of the size of the input.
    public static int lonelyinteger(List<Integer> arr) {
        // Initialize result variable to store the unique element
        int result = 0;

        // Loop through all elements in the list
        for (int num : arr) {
            // XOR the current element with the result.
            // This will cancel out all elements that have a pair, leaving only the unique element
            result ^= num;
        }

        // Return the unique element
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        int result = lonelyinteger(arr);
        System.out.println("The unique element is: " + result);  // 4
    }

}
