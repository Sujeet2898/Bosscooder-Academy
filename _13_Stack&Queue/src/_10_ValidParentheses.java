/*
Question: Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Input: s = "()"
Output: true
Input: s = "()[]{}"
Output: true
Input: s = "(]"
Output: false
 */

import java.util.Stack;

public class _10_ValidParentheses {

    // Time Complexity: O(N), Where N is the length of the string --> As the traversal of the string is done only once.
    // Space Complexity: O(N), Where N is the length of the string --> As the maximum stack size reaches the length of the string.

    public boolean isValid(String str) {

        // Create a stack to hold opening brackets.
        Stack<Character> stack = new Stack<Character>();

        // Loop over characters of string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If current character is opening bracket, add it to stack
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            }

            // Else current character is closing bracket
            else if (ch == ']' || ch == '}' || ch == ')') {

                // 1. If stack is empty, that means parenthesis are invalid, return false.
                if (stack.isEmpty())
                    return false;

                    // 2. Else stack contains opening brackets, Pop the last bracket from the stack. Match it with the current closing bracket. If not a valid match return false.
                else {
                    if (ch == ']') {
                        if (stack.peek() != '[')
                            return false;
                        else
                            stack.pop();
                    } else if (ch == '}') {
                        if (stack.peek() != '{')
                            return false;
                        else
                            stack.pop();
                    } else if (ch == ')') {
                        if (stack.peek() != '(')
                            return false;
                        else
                            stack.pop();
                    }
                }
            }
        }

        // If stack is empty, string is valid.
        return stack.isEmpty();
    }
}