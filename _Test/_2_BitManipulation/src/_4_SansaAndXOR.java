/*
Question: Sansa and XOR
Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine this value.
Example:
arr = [3, 4, 5]
Subarray	Operation	Result
3		    None		3
4		    None		4
5		    None		5
3,4		   3 XOR 4		7
4,5		   4 XOR 5		1
3,4,5	 3 XOR 4 XOR 5	2
Now we take the resultant values and XOR them together:
3^4^5^7^1^2 = 6. Return 6.
Function Description:
Complete the sansaXor function in the editor below.
sansaXor has the following parameter(s):
* int arr[n]: an array of integers
Returns:
* int: the result of calculations
Input Format
The first line contains an integer t, the number of the test cases.
Each of the next t pairs of lines is as follows:
- The first line of each test case contains an integer n, the number of elements in arr.
- The second line of each test case contains n space-separated integers arr[i].
Constraints
1 <= t <= 5
2 <= n <= 10^5
1 <= arr[i] <= 10^8
Sample Input
2
3
1 2 3
4
4 5 7 5
Sample Output
2
0
Explanation
Test case 0:
1^2^3^(1^2)^(2^3)^(1^2^3) = 2
Test case 1:
4^5^7^5^(4^5)^(5^7)^(7^5)^(4^5^7)^(5^7^5)^(4^5^7^5) = 0
Sample Input
2
3
98 74 12
3
50 13 2
Sample Output
110
48
Explanation
Test Case 0:
98^74^12^(98^74)^(74^12)^(98^74^12) = 110
Test Case 1:
50^13^2^(50^13)^(13^2)^(50^13^2) = 48
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
 * Complete the 'sansaXor' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

//    public static int sansaXor(List<Integer> arr) {
//        // Write your code here
//
//    }

//}

public class _4_SansaAndXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

//                int result = Result.sansaXor(arr);
//
//                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}