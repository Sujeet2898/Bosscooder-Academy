/*
BucketSort:
Bucket Sort is a type of sorting algorithm in which the individual elements of the input array are distributed into several groups which are known as buckets.
One bucket is capable of holding more than one element simultaneously. Each bucket is then sorted individually, either by making use of some other sorting algorithm,
or by recursively applying the same bucket sorting algorithm.
Finally, when each bucket has been sorted, they are then combined to form the final and complete sorted array.
Bucket Sort is a stable sorting algorithm.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Time Complexity: O(n + k) where n is the number of elements and k is the number of buckets
// Space Complexity: O(n + k) where n is the number of elements and k is the number of buckets
public class _5_BucketSort {

    public static int[] bucketSort(int[] nums) {

        int bucketLength = nums.length;

        List<List<Integer>> list= new ArrayList<>();

        for(int i=0;i<bucketLength ;i++ )
            list.add(new ArrayList<>());

        for(int i : nums) {
            int position = i/bucketLength >= 0 ? i/bucketLength : 0;
            list.get(position).add(i);
        }
        int k=0;
        for(List<Integer> b : list) {
            Collections.sort(b);
            for(int i : b) {
                nums[k++] = i;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        bucketSort(input);
        for(int i = 0; i < n; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

