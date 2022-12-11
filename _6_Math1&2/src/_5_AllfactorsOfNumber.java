/*
Question: Given n, find all factors of n
 */

import java.util.ArrayList;

public class _5_AllfactorsOfNumber {

    // Brute force approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static ArrayList<Integer> printDivisors1(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    // Optimal approach
    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(n)
    public static ArrayList<Integer> printDivisors2(int n){
        ArrayList<Integer> ans = new ArrayList<>();

        // Note that this loop runs till square root
        for (int i = 1; i <= Math.sqrt(n); i++){
            if (n % i == 0) {
                // If divisors are equal, print only one
                if (n/i == i) {
                    ans.add(i);
                }
                // Otherwise, print both
                else {
                    ans.add(i);
                    ans.add(n / i);
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int n = 100;
        System.out.println(printDivisors1(n)); // output: [1, 2, 4, 5, 10, 20, 25, 50, 100]
        System.out.println(printDivisors2(n)); // output: [1, 100, 2, 50, 4, 25, 5, 20, 10]
    }
}
