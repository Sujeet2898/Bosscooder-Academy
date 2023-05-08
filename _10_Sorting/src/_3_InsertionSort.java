/* In insertion sort, we generally divide the array into sorted and unsorted parts. After that we start picking elements one by one from the unsorted array,
and place it in its correct position in the sorted array. In this way, the sorted array slowly increases and the unsorted array slowly decreases. And at the end, the whole array gets sorted.
Advantage: Stable sort, In-Place sort, Number of swaps reduced unlike bubble sort, Total no. of steps is also reduced for partially sorted array.
Disadvantage: It is generally used when the value of n is small. For larger values of n, it is inefficient.
*/

import java.util.Scanner;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class _3_InsertionSort {
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {    // run in unsorted array
            int current = arr[i];  // picking the current element
            int j = i - 1;         // pick the last index of sorted part
            while(j >= 0 && current < arr[j]) {   // move in the sorted part with help of j till it is greater than 0 and compare current element with index of j element
                //Keep swapping
                arr[j + 1] = arr[j];    //making space for bigger value than current value
                j--;
            }
            //place the element in the correct position if the condition dissatisfied
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        insertionSort(input);  
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

