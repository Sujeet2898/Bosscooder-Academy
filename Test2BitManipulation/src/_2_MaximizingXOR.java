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

//class Result {

    /*
     * Complete the 'maximizingXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

//    public static int maximizingXor(int l, int r) {
//        // Write your code here
//
//    }

//}

public class _2_MaximizingXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

//        int result = Result.maximizingXor(l, r);
//
//        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

