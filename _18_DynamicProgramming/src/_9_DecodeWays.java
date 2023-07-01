/*
Question: Decode Ways
A message containing letters from A-Z can be encoded into numbers using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */

public class _9_DecodeWays {
    // In this problem, each digit can be mapped to a letter (a to z), and the task is to find the total number of ways in which the given string of digits can be decoded into letters.

    // 1. Recursion O(2^n). A char may be decoded alone or by pairing with the next char.
    /*
    Intuition: The basic idea is that a given digit can be decoded alone or in pairs with the next digit. The recursion function numDecodings takes two parameters:
    the index p of the current digit being decoded and the string s being decoded. If the index p reaches the end of the string s, it means that we have found a
    valid decoding and we return 1. If the current digit is 0, we cannot decode it alone, and we return 0. Otherwise, we recursively call numDecodings for the next
    digit and add its result to the current result. Additionally, if the current digit can be paired with the next digit, we also call numDecodings for the next two digits and add its result to the current result.
     */
    public int numDecodings1(String s) {
        return s.length() == 0 ? 0 : numDecodings(0, s);
    }
    private int numDecodings(int p, String s){
        int n = s.length();
        if(p == n) return 1;
        if(s.charAt(p) == '0') return 0;
        int res = numDecodings(p + 1,s);
        if(p < n-1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
            res += numDecodings(p + 2,s);
        return res;
    }

    // 2. Memoization O(n)
    /*
    Intuition: It is a memoized version of the first algorithm. Memoization is used to avoid redundant computations in the recursion. The memoization table mem stores
    the result of numDecodings for each index p that has been computed. If the result for a given index p is already in the memoization table, we return it directly
    without further computation. Otherwise, we compute it recursively as in the first algorithm, and store it in the memoization table before returning it.
     */
    public int numDecodings2(String s) {
        int n = s.length();
        Integer[] mem = new Integer[n];
        return s.length() == 0 ? 0 : numDecodings(0, s, mem);
    }
    private int numDecodings(int p, String s, Integer[] mem) {
        int n = s.length();
        if(p == n) return 1;
        if(s.charAt(p) == '0') return 0;
        if(mem[p] != null) return mem[p];
        int res = numDecodings(p + 1, s, mem);
        if(p < n-1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
            res += numDecodings(p + 2, s, mem);
        return mem[p] = res;
    }

    // 3. dp O(n) time and space, this can be converted from #2 with copy and paste.
    /*
    Intuition: The basic idea is to use a table dp to store the results of subproblems in a bottom-up manner. The table dp has n+1 entries, where dp[i] represents the
    number of ways to decode the substring s[i:] (i.e., the suffix of s starting from index i). We start by initializing dp[n] to 1, since there is only one way to
    decode an empty string. Then, for each index i from n-1 to 0, we check if the current digit can be decoded alone or in pairs with the next digit, and update dp[i]
    accordingly. Finally, we return dp[0], which represents the number of ways to decode the entire string s.
     */
    public int numDecodings3(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--)
            if(s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if(i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    dp[i] += dp[i + 2];
            }
        return dp[0];
    }
}
