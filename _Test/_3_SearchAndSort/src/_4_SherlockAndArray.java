/*
Question: Sherlock And Array
Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right.

Example
arr = [5, 6, 8, 11]
The answer is [8] since 8 is between two subarrays that sum to 11.

arr= [1]
The answer is [1] since left and right sum to 0.

You will be given arrays of integers and must determine whether there is an element that meets the criterion. If there is, return YES. Otherwise, return NO.
 */

import java.util.Arrays;
import java.util.List;

public class _4_SherlockAndArray {

    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int leftSum = 0;
        int rightSum = 0;

        // calculate the sum of all elements in the array
        for (int i = 0; i < n; i++) {
            rightSum += arr.get(i);
        }

        // iterate through the array and check if there is an element that meets the criterion
        for (int i = 0; i < n; i++) {
            rightSum -= arr.get(i);
            if (leftSum == rightSum) {
                return "YES";
            }
            leftSum += arr.get(i);
        }

        // if no element meets the criterion, return "NO"
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 6, 8, 11);
        System.out.println(balancedSums(arr));  // YES

        arr = Arrays.asList(1);
        System.out.println(balancedSums(arr));  // YES

        arr = Arrays.asList(1, 2, 3, 3);
        System.out.println(balancedSums(arr));  // YES
    }
}

