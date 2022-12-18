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

import java.util.List;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

//    public static int lonelyinteger(List<Integer> a) {
//        // Write your code here
//
//    }

}

public class _1_LonelyInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

//        int result = Result.lonelyinteger(a);

//        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
