/*
This implementation uses a single stack to simulate a queue. The enqueue operation is straightforward, simply adding an element to the top of the stack.
The dequeue operation is a bit more complex, as it involves removing all elements except the last one and returning the last element.
The time complexity of the enqueue operation is O(1), as it simply involves pushing an element onto a stack, which takes constant time.
The time complexity of the dequeue operation is O(n), where n is the number of elements in the queue, because in the worst-case scenario
all n elements must be removed from the stack and stored in a temporary stack in order to return the front element.
The space complexity of this implementation is O(n), where n is the number of elements in the queue, because the size of the stack used to store the elements must be large enough to hold all of the elements.
*/

import java.util.Stack;

public class _20_ImplementQueueUsingOneStack {
    private Stack<Integer> stack;

    // Constructor to initialize the stack
    public _20_ImplementQueueUsingOneStack() {
        stack = new Stack<>();
    }

    // Method to add an element to the queue
    public void enqueue(int element) {
        stack.push(element);
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        // If the stack is empty, throw an exception
        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        // If the stack has only one element, return it
        if (stack.size() == 1) {
            return stack.pop();
        }

        // If the stack has more than one element, remove all elements except the last one
        // and store them in a temporary stack, then reverse the order of the elements
        // and return the last element
        int result = 0;
        Stack<Integer> tempStack = new Stack<>();
        while (stack.size() > 1) {
            tempStack.push(stack.pop());
        }
        result = stack.pop();
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return result;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _20_ImplementQueueUsingOneStack queue = new _20_ImplementQueueUsingOneStack();

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