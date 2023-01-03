/*
Question: Check Palindrome
Check whether a given String S is a palindrome using recursion. Return true or false.
Input Format :
String S
Output Format :
'true' or 'false'
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false
 */

import java.util.Scanner;

public class _1_CheckPalindrome {

    // Recursive Approach
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static boolean indexBtao(String input, int startIndex, int endIndex){

        if(startIndex >= endIndex){
            return true;
        }

        if (input.charAt(startIndex) != input.charAt(endIndex)){
            return false;
        }

        return indexBtao(input,startIndex + 1,endIndex - 1);
    }

    public static boolean isStringPalindrome(String input) {

        if(input.length() == 0){
            return true;
        }

        boolean ans = indexBtao(input,0, input.length() - 1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        System.out.println(isStringPalindrome(input));
    }
}
