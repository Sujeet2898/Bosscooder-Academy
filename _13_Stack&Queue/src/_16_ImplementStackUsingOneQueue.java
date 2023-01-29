import java.util.LinkedList;
import java.util.Queue;

public class _16_ImplementStackUsingOneQueue {
    private Queue<Integer> queue;
    public _16_ImplementStackUsingOneQueue() {
        this.queue = new LinkedList<>();
    }

    // Method to add an element to the stack
    public void push(int x) {
        // Number of elements currently in the queue
        int size = queue.size();
        // Add the new element to the queue
        queue.offer(x);
        // Pop all elements from the front of the queue and add them back to the end
        // to maintain the correct order of elements in the stack
        for (int i = 0; i < size; i++) {
            int curr = queue.poll();
            queue.offer(curr);
        }
    }

    // Method to remove the top element from the stack
    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Return the front element from the queue, which is the top element of the stack
        return queue.poll();
    }

    // Method to return the top element of the stack
    public int top() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        // Return the front element from the queue, which is the top element of the stack
        return queue.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        _16_ImplementStackUsingOneQueue stack = new _16_ImplementStackUsingOneQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack empty? " + stack.isEmpty());
    }
/*
Output:
Top element: 3
Popped element: 3
Popped element: 2
Stack empty? false
 */
}