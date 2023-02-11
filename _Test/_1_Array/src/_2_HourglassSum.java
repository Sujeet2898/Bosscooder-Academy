import java.util.List;

public class _2_HourglassSum {

/*
Given a 6 * 6 2D Array, arr:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
An hourglass in A is a subset of values with indices falling in this pattern in arr's graphical representation:
a b c
  d
e f g
There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values.
Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum. The array will always be 6 * 6.
Example
arr =
-9 -9 -9  1 1 1
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
The 16 hourglass sums are:
-63, -34, -9, 12,
-10,   0, 28, 23,
-27, -11, -2, 10,
  9,  17, 25, 18
The highest hourglass sum is 28 from the hourglass beginning at row 1, column 1:
0 4 3
  1
8 6 6
*/

    public static int hourglassSum1(List<List<Integer>> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.size() - 2; ++i) {
            for(int j = 0; j < arr.size() - 2; ++j) {
                int sum = arr.get(i).get(j) +
                        arr.get(i).get(j+1) +
                        arr.get(i).get(j+2) +
                        arr.get(i+1).get(j+1) +
                        arr.get(i+2).get(j) +
                        arr.get(i+2).get(j+1) +
                        arr.get(i+2).get(j+2);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int hourglassSum2(List<List<Integer>> arr) {
        // Write your code here
        int maxSumHourGlass = Integer.MIN_VALUE;
        for (int p = 0; p <= 3; p++) {
            for (int q = 0; q <= 3; q++) {
                int sumOfOneHourglass = 0;
                sumOfOneHourglass = arr.get(p).get(q) +
                        arr.get(p).get(q + 1) +
                        arr.get(p).get(q + 2)  +
                        arr.get(p + 1).get(q + 1) +
                        arr.get(p + 2).get(q) +
                        arr.get(p + 2).get(q + 1) +
                        arr.get(p + 2).get(q + 2);
                if (maxSumHourGlass < sumOfOneHourglass) {
                    maxSumHourGlass = sumOfOneHourglass;
                }
            }
        }
        return maxSumHourGlass;
    }
}