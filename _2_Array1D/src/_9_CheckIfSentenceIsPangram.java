/*
Question: Check if the Sentence Is Pangram
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
 */

public class _9_CheckIfSentenceIsPangram {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean checkIfPangram1(String sentence) {
        int n = sentence.length();
        boolean[] arr = new boolean[26];
        for(int i = 0; i < n; i++){
            arr[sentence.charAt(i) - 'a'] = true;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] == false){
                return false;
            }
        }
        return true;
    }

    // Using Bitwise
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean checkIfPangram2(String sentence) {
        int n = sentence.length();
        int result = 0;
        for(int i = 0; i < n; i++){
            result = result | (1 << sentence.charAt(i) - 'a');
            if(result == (1 << 26) - 1){
                return true;
            }
        }
        return false;
    }
}
