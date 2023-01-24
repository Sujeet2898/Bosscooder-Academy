/*
Problem Statement: Sort 0 1 2
You have been given an integer array/list(ARR) of size 'N'. It only contains 0s, 1s and 2s. Write a solution to sort this array/list.
Note :
Try to solve the problem in 'Single Scan'. ' Single Scan' refers to iterating over the array/list just once or to put it in other words, you will be visiting each element in the array/list just once.
 */

import java.util.Scanner;

public class _9_Sort012 {

     /*
    Following imp points:
    1. i to k -> unknown area
    2. k+1 to end -> 2's area
    3. j to i-1 -> 1's area
    4. 0 to j-1 -> 0's area
    3 Swapping steps:
    1.  a[i] = 0
        swap(a,i,j)
        i++
        j++
    2.  a[i] = 1
        i++
    3.  a[i] = 2
        swap(a,i,k)
        k--
     */

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void sort012(int[] arr){

        // starting position of j,i,k
        int j = 0;
        int i = 0;
        int k = arr.length - 1;

        // Work is done till unknown is left
        while (i <= k){
            if (arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }else if (arr[i] == 1){
                i++;
            }else {
                swap(arr, i, k);
                k--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
Input:
7
0 1 2 1 2 1 2
Output:
0 1 1 1 2 2 2
Input:
6
0 1 2 2 1 0
Output:
0 0 1 1 2 2
 */
