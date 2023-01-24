
/* Logic: We fill the heaviest element from last so that the length of the array to be sorted decreases from end.
In bubble sort, we run n-1 times loop. In the first loop, we pick the heaviest element from the array and push them at the end.
In the second loop, we pick the second heaviest element and push them at the second last and so on, so that elements get arranged from the end.
And we are only left with the nth element which is the lightest one which automatically gets placed at the beginning.
And everytime, we get the heaviest element by swapping the elements pairwise.
Disadvantage: Unnecessary swapping is done at each iteration unlike selection sort.
Advantage: It is In-Place sort. It is also stable as it does not change the relative order of elements with equal keys.
*/

import java.util.Scanner;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
public class _1_BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        bubbleSort(input);
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

