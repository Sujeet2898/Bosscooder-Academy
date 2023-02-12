/*
Question: Missing Numbers
Given two arrays of integers, find which elements in the second array are missing from the first array.
Example
arr = [7,2,5,3,5,3]

brr = [7,2,5, 4, 6, 3, 5, 3]

The brr array is the orginal list. The numbers missing are [4, 6].

Notes
If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
Return the missing numbers sorted ascending.
Only include a missing number once, even if it is missing multiple times.
The difference between the maximum and minimum numbers in the original list is less than or equal to 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3_MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        List<Integer> result = new ArrayList<>();
        int[] frequency = new int[10001];

        // calculate the frequency of numbers in brr
        for (int i = 0; i < brr.size(); i++) {
            frequency[brr.get(i)]++;
        }

        // subtract the frequency of numbers in arr from the frequency of numbers in brr
        for (int i = 0; i < arr.size(); i++) {
            frequency[arr.get(i)]--;
        }

        // add missing numbers to the result list
        for (int i = 0; i < 10001; i++) {
            if (frequency[i] > 0) {
                result.add(i);
            }
        }

        // return the result
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(7, 2, 5, 3, 5, 3);
        List<Integer> brr = Arrays.asList(7, 2, 5, 4, 6, 3, 5, 3);
        List<Integer> missingNumbers = missingNumbers(arr, brr);
        System.out.println(missingNumbers);   // [4, 6]

        arr = Arrays.asList(1, 2, 3, 4, 5);
        brr = Arrays.asList(1, 2, 3, 4, 5);
        missingNumbers = missingNumbers(arr, brr);  // []
        System.out.println(missingNumbers);

        arr = Arrays.asList(4, 2, 5, 7, 9);
        brr = Arrays.asList(4, 2, 5, 7, 9, 1, 3, 6, 8);
        missingNumbers = missingNumbers(arr, brr);
        System.out.println(missingNumbers);  // [1, 3, 6, 8]
    }
}
