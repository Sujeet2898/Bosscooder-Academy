/*
The time complexity of the push and pop operations in the stack implemented using arrays is O(1). This is because adding or removing an element from the top of the stack takes constant time regardless of the number of elements in the stack.
The space complexity of the stack is O(n), where n is the size of the stack. This is because we need to allocate memory for an array of size n to store the elements in the stack.
Note that in the implementation, the stack size is fixed when it is created and cannot be dynamically resized. This means that the space complexity is O(n) even if the stack is not full. If dynamic resizing is required, a more sophisticated implementation such as a linked list-based stack should be used.
 */

import java.util.Arrays;

public class _14_ImplementStackUsingArrays {
    private int[] arr;  // array to store elements of stack
    private int top;      // top of the stack
    private int size;      // a variable to keep track of the number of elements in the stack

    // constructor to initialize stack with a size
    public _14_ImplementStackUsingArrays(int size) {
        arr = new int[size];
        top = -1;  // initialize top of stack to -1
        this.size = size;
    }

    // method to check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // method to check if stack is full
    public boolean isFull() {
        return top == arr.length - 1;
    }

    // method to push an element into the stack
    public void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = x;
    }

    // method to pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        int x = arr[top--];
        return x;
    }

    // method to get the top element of the stack
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int x = arr[top];
        return x;
    }

    // method to print the stack
    public void printStack() {
        for (int i = 0; i <= top; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        _14_ImplementStackUsingArrays stack = new _14_ImplementStackUsingArrays(5);  // create a stack of size 5

        stack.push(1);  // push 1 into the stack
        stack.push(2);  // push 2 into the stack
        stack.push(3);  // push 3 into the stack

        stack.printStack();  // [1, 2, 3, 0, 0]
        System.out.println();

        System.out.println("Popped element: " + stack.pop());  // Popped element: 3
        System.out.println("Popped element: " + stack.pop());  // Popped element: 2

        stack.printStack();  // [1, 0, 0, 0, 0]
        System.out.println();

        System.out.println("Top element: " + stack.peek());  // Top element: 1
    }
}