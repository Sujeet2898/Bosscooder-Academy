import java.util.Collections;
import java.util.PriorityQueue;

public class _2_KthSmallest {

    public static void main(String[] args) {
        int arr[] = {10,7,11,30,20,38,2,45};

        int k = 4;

        System.out.println(kthSmallestUsingMinHeap(arr, k));  // 11
        System.out.println(kthSmallestUsingMaxHeap(arr, k));  // 11
    }

    // Time Complexity: O(klogk + (N-k)logk)
    // Space Complexity: O(k)
    public static int kthSmallestUsingMaxHeap(int arr[], int k){
        if(arr.length < k){
            System.out.println("Please give correct input !");
            return -1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            maxHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    // Time Complexity: O(N + klogN)
    // Space Complexity: O(N)
    public static int kthSmallestUsingMinHeap(int[] arr, int k){
        if(arr.length < k){
            System.out.println("Please give correct input !");
            return -1;
        }

        PriorityQueue<Integer> miniHeap = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++){
            miniHeap.add(arr[i]);
        }

        for(int i = 0; i < k-1; i++){
            miniHeap.poll();
        }

        return miniHeap.peek();
    }
}