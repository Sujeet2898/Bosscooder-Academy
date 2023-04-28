/*
Question: Is SubSequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the
characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

public class _6_IsSubSequence {

    // Because we want to preserve the relative order of characters, assign a pointer to each of the string and iterate until one of them ends.
    // At every iteration, if there is a match, increment both pointers, otherwise only increment the pointer of the larger string.
    public boolean isSubsequence(String s, String t) {
        int spoint = 0;
        int tpoint = 0;
        while(spoint < s.length() && tpoint < t.length()){
            if(s.charAt(spoint) == t.charAt(tpoint)){
                spoint++;
            }
            tpoint++;
        }
        // return spoint == s.length();
        if(spoint == s.length()) return true;
        return false;
    }
}
  
