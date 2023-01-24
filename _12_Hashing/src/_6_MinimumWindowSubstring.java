/*
Link: https://www.youtube.com/watch?v=e1HlptlipB0&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=8
Question : Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates)
is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
 */

import java.util.HashMap;
import java.util.Scanner;

public class _6_MinimumWindowSubstring {

    public static String minWindow(String s, String t){
        String ans = "";

        // Creating frequencyMap of s2
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);    // take character
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int desireMatchCount = t.length();
        // Creating frequencyMap of s1
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true){
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < s.length() - 1 && matchCount < desireMatchCount){
                i++;
                char ch = s.charAt(i);    // hold character
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                // checking acquired character
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){   // less or equal
                    matchCount++;
                }
                f1 = true;
            }

            // collect answer and release
            while (j < i && matchCount == desireMatchCount){
                // collect ans
                String potentialAns = s.substring(j + 1, i + 1); // j = -1 to i as i + 1 is not included in subString
                if (ans.length() == 0 || potentialAns.length() < ans.length()){
                    ans = potentialAns;
                }

                j++;
                char ch = s.charAt(j); // hold character
                // release character
                if (map1.get(ch) == 1){
                    map1.remove(ch);
                }else {
                    map1.put(ch, map1.get(ch) - 1);
                }

                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){  // not equal
                    matchCount--;
                }
                f2 = true;
            }

            if (f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(minWindow(s1,s2));
    }
}

/*
Input:
timetopractice
toc
Output:
toprac
Input:
dbaecbbabdcaafbddca
abbcdc
Output:
cbbabdc
 */