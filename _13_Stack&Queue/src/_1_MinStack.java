import java.util.Stack;

/*
Question: Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class _1_MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public _1_MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= getMin()) {
            minStack.push(val);
        }
        valueStack.push(val);
    }

    public void pop() {
        if(valueStack.peek() == getMin()) {
            minStack.pop();
        }
        valueStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
