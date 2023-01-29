/*
A dequeue, also known as a double-ended queue, is a data structure that allows for the insertion and removal of elements from both the front and the end in constant time.
It is a hybrid between a queue and a stack, as it supports both first-in-first-out (FIFO) and last-in-first-out (LIFO) behavior.

Dequeues can be implemented using arrays, linked lists, or other data structures. The specific implementation affects the time and space complexity of operations such as insertion and removal.
The time complexity of the push operation in a stack implemented using a dequeue is O(1) on average. This is because adding an element to either the front or the end of a dequeue takes constant time.
The time complexity of the pop operation is also O(1) on average. This is because removing an element from either the front or the end of a dequeue takes constant time.
The space complexity of the stack implemented using a dequeue is O(n), where n is the number of elements in the stack. This is because the size of the dequeue used to store the elements of the stack must be large enough to hold all of the elements. In the worst case, the size of the dequeue may need to be resized to accommodate a larger number of elements, which takes O(n) time.
 */

import java.util.LinkedList;

public class _17_ImplementStackUsingDeQue {
    private LinkedList<Integer> deque = new LinkedList<>();

    // pushes element at the top of the stack
    public void push(int x) {
        deque.addFirst(x);
    }

    // removes and returns the top element of the stack
    public int pop() {
        if (deque.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return deque.removeFirst();
    }

    // returns the top element of the stack
    public int top() {
        if (deque.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return deque.getFirst();
    }

    // returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        _17_ImplementStackUsingDeQue stack = new _17_ImplementStackUsingDeQue();
        // push elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.top());
        System.out.println("Popped element is: " + stack.pop());

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
/*
Top element is: 3
Popped element is: 3
Stack is empty: false
 */
}