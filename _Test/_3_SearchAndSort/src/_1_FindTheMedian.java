/*
Question: Find the Median
The median of a list of numbers is essentially its middle element after sorting. The same number of elements occur after it as before. Given a list of numbers with an odd number of elements, find the median?
Example
arr 5,3,1,2,4]
The sorted array arr = [1, 2, 3, 4, 5]. The middle element and the median is 3.

Function Description
Complete the findMedian function in the editor below.
findMedian has the following parameter(s):
int arr[n]: an unsorted array of integers

Returns
⚫int: the median of the array

Input Format
The first line contains the integer r, the size of arr. The second line contains n space-separated integers arr[i]

Constraints
1≤ n ≤ 1000001
⚫n is odd
•-10000 ≤ arr[i] ≤ 10000

Sample Input
7
0124653
Sample Output
3
Explanation
The sorted arr= [0, 1, 2, 3, 4, 5, 6]. It's middle element is at arr[3] = 3
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1_FindTheMedian {

    public static int findMedian(List<Integer> arr) {
        // sort the list
        Collections.sort(arr);

        // find the middle element
        int mid = arr.size() / 2;

        // return the median value
        return arr.get(mid);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int median = findMedian(arr);
        System.out.println(median);  // 3

        arr = Arrays.asList(7, 14, 21, 28, 35, 42);
        median = findMedian(arr);
        System.out.println(median);  // 28

        arr = Arrays.asList(3, 5, 7, 9, 11, 13);
        median = findMedian(arr);
        System.out.println(median);  // 9
    }
}
