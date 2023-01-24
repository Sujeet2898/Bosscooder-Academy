/*
Quick sort:
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given array around the picked pivot.
There are many versions of quickSort that pick pivot in different ways.
Always pick the first element as a pivot.
Always pick the last element as a pivot (implemented below)
Pick a random element as a pivot.
Pick median as the pivot.
The key process in quickSort is a partition(). The target of partitions is, given an array and an element x of an array as the pivot, put x at its correct
position in a sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.
 */

import java.util.Scanner;
public class _8_Quicksort {

    // Average Time Complexity: O(nlogn)
    // Worst Time Complexity: O(n^2)
    // Space Complexity: O(logn)

    public static void sortArray(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    private static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallerNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivotElement) {
                smallerNumCount++;
            }
        }
        int temp = a[si + smallerNumCount];
        a[si + smallerNumCount] = pivotElement;
        a[si] = temp;

        // Take i = si & j = ei to avoid runtimeError (ArrayIndexOutOfBoundsException)
        int i = si;
        int j = ei;
        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                temp = a[i];      // If both above condition is incorrect
                a[i] = a[j];      // So, we swap both wrong elements left and right of pivotElement
                a[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallerNumCount;    // return pivotIndex
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        sortArray(input);
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

