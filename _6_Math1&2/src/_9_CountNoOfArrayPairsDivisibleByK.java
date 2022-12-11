/*
Question: Given an array of integers arr of even length n and an integer k. Count No Of ArrayPairs Divisible By K
 */

public class _9_CountNoOfArrayPairsDivisibleByK {

    // Brute force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int countPair1(int[] arr, int k){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if((arr[i] + arr[j]) % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal approach
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    public static int countPair2(int[] arr, int k){
        int count = 0;
        int[] frequency = new int[k];
        for(int val : arr){
            val %= k;
            frequency[val]++;
        }

        for(int i = 0; i < k; i++){
            if(i == 0){
                count += nCr(frequency[0], 2);
            }
            if(i == k/2){
                count += nCr(frequency[k/2], 2);
            }
            for (int j = i + 1; j < k; j++){
                if((i + j) % k == 0){
                    count += (frequency[i] * frequency[j]);
                }
            }
        }
        return count;
    }

    public static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1, 7, 5, 3};
        int[] arr2 = {2, 2, 1, 7, 5, 3, 8, 9, 15, 12, 13, 7, 3};
        int k = 4;
        System.out.println(countPair1(arr1, k)); // output: 5 --> (2,2), (1,7), (1,3), (7,5), (5,3)
        System.out.println(countPair2(arr1, k)); // output: 5 --> (2,2), (1,7), (1,3), (7,5), (5,3)
        System.out.println(countPair1(arr2, k)); // output: 22
        System.out.println(countPair2(arr2, k)); // output: 22
    }
}
