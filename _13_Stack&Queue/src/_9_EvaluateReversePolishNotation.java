/*
Question: Evaluate Reverse Polish Notation
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */

import java.util.Stack;

public class _9_EvaluateReversePolishNotation {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }
            else if(tokens[i].equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }
            else if(tokens[i].equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }
            else if(tokens[i].equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }
            else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}
