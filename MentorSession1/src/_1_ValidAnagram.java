/*
Feedback for the mentor session on 2022-12-10 from 10:00 to 11:00
-----------------------------------------------------------------
Feedback
-> Need to work on your communication skills -> Missing clarity on dry runs -> Handle edge cases well -> Code writing skills are good
-----------------------------------------------------------------
Action Items
-> Dry run all your questions -> More mock interviews
-----------------------------------------------------------------
 */

/*
Question: Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Input: s = "anagram", t = "nagaram"
Output: true
 */

import java.util.Arrays;
import java.util.HashMap;

public class _1_ValidAnagram {

    // Time Complexity: O(n * logn) where n is length of word
    // Space Complexity: O(1)
    public boolean isAnagram1(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        return String.valueOf(sc).equals(String.valueOf(tc)) ? true : false;
    }

    // Time Complexity: O(n) where n is length of word
    // Space Complexity: O(n)
    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);

            if (!map.containsKey(ch)){
                return false;
            }else if (map.get(ch) == 1){
                map.remove(ch);
            }else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }

    // Time Complexity: O(n) where n is length of word
    // Space Complexity: O(1)
    public boolean isAnagram(String s, String t) {

        // We need to maintain an integer array to mark the count of the characters in those 2 strings.
        int[] chars = new int[26];
        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen) {
            return false;
        }

        // For each character in the string s, we will increment the value of the respective index by 1.
        for(int i = 0; i < sLen; i++) {
            chars[s.charAt(i) - 'a']++;
        }

        // Iterate the string t, and for the characters in t, decrement the value of those indexes by 1
        for(int i = 0; i < tLen; i++) {
            chars[t.charAt(i) - 'a']--;
        }

        // If these 2 strings are anagram, then after decrementing the value, all the values in the array must be 0
        for(int val : chars) {
            if(val != 0) {
                return false;
            }
        }

        return true;
    }
}
