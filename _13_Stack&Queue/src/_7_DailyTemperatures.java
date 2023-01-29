/*
Question: Daily Temperatures
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
 */

import java.util.Scanner;
import java.util.Stack;

public class _7_DailyTemperatures {

    // Brute force approach
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int days = 0;
            for (int j = i; j < n; j++) {
                if (temperatures[i] >= temperatures[j]) {
                    days++;
                }
                else {
                    ans[i] = days;
                    break;
                }
            }
        }

        return ans;
    }

    // Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > st.peek().temp) {
                ans[st.peek().idx] = i - st.peek().idx;
                st.pop();
            }

            st.push(new Pair(temperatures[i], i));
        }

        return ans;
    }

    class Pair {
        int temp;
        int idx;

        Pair(int temp, int idx) {
            this.temp = temp;
            this.idx = idx;
        }
    }

}
