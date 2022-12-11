/*
Question: Given n, find if factors are even or odd
 */

import java.util.ArrayList;

public class _6_FactorsEvenOrOdd {

    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(n)
    public static String factorsEvenOrOdd1(int n){
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
        int count = 0;
        for(int i = 0; i < ans.size(); i++){
            count++;
        }
        if(count%2 != 0){
            return "odd";
        }else {
            return "even";
        }
    }

    // Time Complexity: O(logn) -> for finding sqrt internally
    // Space Complexity: O(1)
    public static String factorsEvenOrOdd2(int n){
        int sqrt = (int)Math.sqrt(n);
        if(sqrt * sqrt == n){
            return "odd";
        }else {
            return "even";
        }
    }

    public static void main(String args[]){
        int n = 100;
        System.out.println(factorsEvenOrOdd1(n)); // output: odd
        System.out.println(factorsEvenOrOdd2(n)); // output: odd
    }
}
