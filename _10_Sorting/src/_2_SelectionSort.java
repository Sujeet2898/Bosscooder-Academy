
/* Logic: We fill the smallest element from the beginning so that the length of the array to be sorted decreases from front.
In selection sort, we pick the smallest element from the array and push them at the beginning.
We also run a n-1 times loop. In the first loop, we assume the 0th index of the array as the smallest element and keep comparing it with the next element
to find the appropriate position of the smallest element of the array. And swap that smallest element with the 0th index element.
In the second loop, we assume the 1th index of the array as the smallest element and continue the same process for it and so on.
Advantage: One swapping per iteration unlike bubble sort. And In-Place sort.
*/

import java.util.Scanner;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class _2_SelectionSort {
    public static void selectionSort(int[] arr) {
        for(int  i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            //swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        selectionSort(input);
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

