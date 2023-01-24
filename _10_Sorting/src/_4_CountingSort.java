/*
Counting sort:
1. Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted.
2. It is not a comparison-based sorting. Its running time complexity is O(n) with space proportional to the range of data.
3. Counting sort is not a stable algorithm.
 */

import java.util.Scanner;

// Time Complexity: O(n)
// Space Complexity: O(n)
public class _4_CountingSort {

    public static int[] countingSort(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i: arr){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int range = max - min + 1;
        int[] countArray = new int[range];
        int[] output = new int[n];

        // find the count of every element from the original array
    /*
        Note:
        Here I am subtracting with min, in order to deal with all -ve values
    */
        for(int val: arr) {
            countArray[val - min]++;
        }


        // modify the countArray by adding current index value with its previous index vlaues
        for(int i = 1; i < range; i++) {
            countArray[i] += countArray[i - 1];
        }


        // filling values in output array using original array by traversing it from the end
        for(int i = n - 1; i >= 0; i--){
            // int val = countArray[arr[i]-min]-1;
            output[countArray[arr[i] - min] -1] = arr[i];
            countArray[arr[i] - min]--;
        }


        // copying output array to arr
        for(int i = 0; i < n; i++)
            arr[i] = output[i];

        return arr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        countingSort(input);
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

