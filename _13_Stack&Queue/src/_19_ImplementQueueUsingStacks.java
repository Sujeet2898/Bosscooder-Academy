/*
In this implementation, two stacks are used to simulate a queue. The stack1 is used to store the elements in a queue fashion, and the stack2 is used as an auxiliary stack to reverse the order of the elements.
The enqueue method simply pushes the element onto stack1. The dequeue method checks if stack2 is empty, and if it is, it transfers all elements from stack1 to stack2 before popping the top element of stack2, which is the front element of the queue.
The isEmpty method returns true if both stacks are empty, and false otherwise.

The time complexity of the enqueue operation in a queue implemented using stacks is O(1), as it simply involves pushing an element onto a stack, which takes constant time.
The time complexity of the dequeue operation is O(n), where n is the number of elements in the queue, because in the worst case scenario all n elements must be transferred from stack1 to stack2 in order to return the front element.
The space complexity of the queue implemented using stacks is O(n), where n is the number of elements in the queue, because the size of the stacks used to store the elements must be large enough to hold all of the elements.
 */

import java.util.Stack;

public class _19_ImplementQueueUsingStacks {
    private Stack<Integer> stack1; // stack to store elements in a queue fashion
    private Stack<Integer> stack2; // auxiliary stack to reverse the elements

    // Constructor to initialize the two stacks
    public _19_ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add an element to the queue
    public void enqueue(int element) {
        stack1.push(element);
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Return the top element of stack2, which is the front element of the queue
        return stack2.pop();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        _19_ImplementQueueUsingStacks queue = new _19_ImplementQueueUsingStacks();

        // Adding elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Removing and printing elements from the queue
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 3
    }
}