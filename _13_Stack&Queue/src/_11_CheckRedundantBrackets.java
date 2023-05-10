/*
Question: Check redundant brackets
For a given expression in the form of a string, find if there exist any redundant brackets or not. It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
Input:
(x+y*(a-b))
Output:
false

Input:
(a+b*((a/c-d)))
Output:
true
 */

import java.util.Stack;  
import java.util.*;

public class _11_CheckRedundantBrackets {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean checkRedundantBrackets(String expression) {

        Stack<Character> stack = new Stack<Character>();

        int count=0;

        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);

            if (ch == ')' ){

                while(!stack.isEmpty() && stack.peek() != '('){
                    stack.pop();
                    count++;
                }

                if (count == 0 || count == 1){      // count == 1 in case of expression like (a), (g), etc which are redundants
                    return true;
                }

                stack.pop();    // also pop opening bracket and reset count to 0
                count = 0;
            }

            else {        // pushing all characters into stack until we reaches ch == ')'
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println(checkRedundantBrackets(expression));
    }
}
