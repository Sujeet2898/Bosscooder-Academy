/*
Question: Palindrome Number
Given an integer x, return true if x is a palindrome, and false otherwise.

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */

public class _2_PalindromeNumber {

    public boolean isPalindrome1(int x) {
         if(x < 0){
             return false;
         }
         int rev = 0;
         int temp = x;
         while(temp != 0){
             int rem = temp % 10;
             rev = rev * 10 + rem;
             temp = temp / 10;
         }
         if (x == rev){
             return true;
         }
         else{
             return false;
         }
    }
  
    public boolean isPalindrome2(int x){
        String str = Integer.toString(x);
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

}
