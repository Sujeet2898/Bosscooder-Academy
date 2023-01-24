/*
Merge sort:
Merge sort is a sorting algorithm that works by dividing an array into smaller subarrays, sorting each subarray, and
then merging the sorted subarrays back together to form the final sorted array.
 */

import java.util.Scanner;
public class _7_MergeSort {

    // Time Complexity: O(nlogn) for both worst and average
    // Space Complexity: O(n)

    public static int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return nums;
    }

    public static void mergesort(int[] nums, int si, int ei){
        if(si == ei){
            return;
        }
        int mid = (si + ei) / 2;
        mergesort(nums, si, mid);
        mergesort(nums, mid + 1, ei);
        merge(nums, si, mid, ei);

    }

    public static void merge(int[] nums, int si, int mid, int ei){
        int i = si;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[ei - si + 1];
        while( i <= mid && j <= ei){
            if (nums[i] < nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }
            else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }

        //copy remaining elements
        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        //copy remaining elements
        while (j <= ei) {
            temp[k] = nums[j];
            k++;
            j++;
        }

        // putting element in sorted array in original array
        k = 0;
        for (k = 0; k < temp.length; k++){
            nums[si + k] = temp[k];
        }
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

