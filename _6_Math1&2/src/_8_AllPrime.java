/*
Question: Find all prime from 1 to n
*/

import java.util.ArrayList;

public class _8_AllPrime {

    // Time Complexity: O(n * sqrt(max(A)) --> sqrt(max(A) for finding prime or not
    // Space Complexity: O(n)
    public static ArrayList<Integer> allPrime1(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            if (isPrime(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Optimal approach sieveOfEratosthenes
    // Time Complexity: O(n * log(log(n)))
    // Space Complexity: O(n)
    public static ArrayList<Integer> allPrime2 (int n){
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == true) {
                // Update all multiples of i greater than or equal to the square of it numbers which are multiple of i and are less than i^2 are already been marked.
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }

        // Print all prime numbers
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(allPrime1(n)); // output: [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
        System.out.println(allPrime2(n)); // output: [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
    }
}
