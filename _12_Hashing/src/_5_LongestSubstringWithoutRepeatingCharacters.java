/*
Question: Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _5_LongestSubstringWithoutRepeatingCharacters {

    // Using All Substring Approach
    // Time Complexity: O(N^3)  ----We would be creating every substring, which takes N^2 time, and for checking whether it consists of unique characters, it will take N time.
    // Space Complexity: O(N)  ----Since we have used set for checking duplication in strings.

    public static int lengthOfLongestSubstring1(String str) {
        int n = str.length();
        int ans = 0;

        // Check for every possible substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {

                // If substring contains unique character then update the maximum.
                if (allUnique(str, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }

        return ans;
    }

    public static boolean allUnique(String str, int start, int end) {
        // For storing every character of string
        HashSet<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {

            Character ch = str.charAt(i);
            // If a character is already there then we have found duplicates , so we need to return false
            if (set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }

        return true;
    }

    // Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    public static int lengthOfLongestSubstring2(String str) {
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // Acquire till you become invalid
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);    // find character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Checking repeating character
                if (map.get(ch) == 2){
                    break;

                }else {
                    // update ans
                    int length = i - j;
                    if (length > ans){
                        ans = length;
                    }
                }
            }

            // release till you become valid
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j); // hold character
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }
        return ans;
    }

    // Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    // No. of Substring = n(n+1)/2
    public static int CountOfSubstringsUniqueCharacters(String str) {
        int ans = 0;

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            // For terminating
            boolean f1 = false;
            boolean f2 = false;

            // Acquire till you become invalid
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);    // find character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Checking repeating character
                if (map.get(ch) == 2) {
                    break;

                } else {
                    // update ans
                    ans += i - j;
                }
            }

            // release till you become valid
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j); // hold character
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 1) {
                    ans += i - j;
                    break;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(lengthOfLongestSubstring1(str));
        System.out.println(lengthOfLongestSubstring2(str));
        System.out.println(CountOfSubstringsUniqueCharacters(str));
    }
}