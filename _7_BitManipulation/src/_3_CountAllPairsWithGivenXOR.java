/*
Question: Count all pairs with given XOR
Given an array of distinct positive integers and a number x, find the number of pairs of integers in the array whose XOR is equal to x.

Input : arr[] = {5, 4, 10, 15, 7, 6}, x = 5
Output : 1
Explanation :  (10 ^ 15) = 5

Input : arr[] = {3, 6, 8, 10, 15, 50}, x = 5
Output : 2
Explanation : (3 ^ 6) = 5 and (10 ^ 15) = 5
 */

import java.util.HashMap;
import java.util.HashSet;

public class _3_CountAllPairsWithGivenXOR {

    // If there are "no duplicates" in the input array
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int xorPairCount1(int arr[], int x) {
        int n = arr.length;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // If there exist an element in set set with XOR equals to x^arr[i], that means there exist an element such that the XOR of element with arr[i] is equal to x, then increment count.
            if (set.contains(x ^ arr[i])){
                result++;
            }

            // Make element visited
            set.add(arr[i]);
        }

        // return total count of pairs with XOR equal to x
        return result;
    }

    // If there are "duplicates" in the input array
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int xorPairCount2(int arr[], int x) {
        int n = arr.length;
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0;  i < n ; i++){
            int curr_xor = x ^ arr[i];

            // If there exist an element in map map with XOR equals to x^arr[i], that means there exist an element such that the XOR of element with arr[i] is equal to x, then increment count.
            if (map.containsKey(curr_xor)) {
                result += map.get(curr_xor);
            }

            // Increment count of current element
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        // return total count of pairs with XOR equal to x
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {5, 4, 10, 15, 7, 6};
        int x1 = 5;
        System.out.print(xorPairCount1(arr1, x1));  // Output: 1

        System.out.println();

        int arr2[] = {2, 5, 2};
        int x2 = 0;
        System.out.print(xorPairCount2(arr2, x2));  // Output: 1
    }
}
