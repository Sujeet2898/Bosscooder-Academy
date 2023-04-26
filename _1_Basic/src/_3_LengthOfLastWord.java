/*
Question: Length of Last Word
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
 */

public class _3_LengthOfLastWord {

    public int lengthOfLastWord1(String s) {
        String str = s.trim();
        int count = 0;
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    public int lengthOfLastWord2(String s){
        String[] arr = s.split(" ");
        return arr.length == 0 ? 0 : arr[arr.length-1].length();
    }
}  
