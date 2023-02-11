/*
Question: Sum vs XOR
Given an integer n, find each x such that:
* 0 <= x <= n
where  denotes the bitwise XOR operator. Return the number of x's satisfying the criteria.
Example
n = 4
There are four values that meet the criteria:
* 4+0 = 4^0 = 4
* 4+1 = 4^1 = 5
* 4+2 = 4^2 = 6
* 4+3 = 4^3 = 7
Return 4.
Function Description:
Complete the sumXor function in the editor below.
sumXor has the following parameter(s):
- int n: an integer
Returns:
- int: the number of values found
Input Format:
A single integer, n.
Constraints:
0 <= n <= 10^15
Subtasks
0 <= n <= 100 for 60% of the maximum score
Output Format:
Sample Input
5
Sample Output
2
Explanation
For n = 5, the x values 0 and 2 satisfy the conditions:
* 5+0=5, 5^0=5
* 5+2=7, 5^2=7
Sample Input
10
Sample Output
4
Explanation
For n = 10, the x values 0, 1, 4, and 5 satisfy the conditions:
* 10+0=10, 10^0=10
* 10+1=11, 10^1=11
* 10+4=14, 10^4=14
* 10+5=15, 10^5=15
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
 * Complete the 'sumXor' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts LONG_INTEGER n as parameter.
 */

//    public static long sumXor(long n) {
//        // Write your code here
//
//    }

//}

public class _3_SumvsXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

//        long result = Result.sumXor(n);
//
//        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}