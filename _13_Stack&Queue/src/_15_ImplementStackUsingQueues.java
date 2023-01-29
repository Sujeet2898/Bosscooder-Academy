/*
The time complexity of this implementation is O(1) for push and pop operations as we are using two queues, so the operations are executed in constant time.
The space complexity of this implementation is O(n), where n is the number of elements in the stack, as we need to store all elements in the two queues.
 */

import java.util.LinkedList;
import java.util.Queue;

public class _15_ImplementStackUsingQueues {

    Queue<Integer> q1;
    Queue<Integer> q2;

    // Initialize two Queues, q1 and q2, for implementing Stack.
    public _15_ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // This function will add the element to the top of the Stack.
    public void push(int data) {
        q1.add(data);
    }

    // This function will remove the top element from the Stack.
    public int pop() {
        int temp;
        // If there is only one element left in the Queue, then return it.
        if (q1.size() == 1) {
            return q1.remove();
        }
        // Transfer all the elements of q1 to q2 except the last one.
        while (q1.size() != 1) {
            temp = q1.remove();
            q2.add(temp);
        }
        // Store the last element of q1 in a variable.
        int data = q1.remove();
        // Transfer all the elements of q2 to q1.
        while (!q2.isEmpty()) {
            temp = q2.remove();
            q1.add(temp);
        }
        return data;
    }

    // This function will return the top element of the Stack.
    public int top() {
        int temp;
        // If there is only one element left in the Queue, then return it.
        if (q1.size() == 1) {
            return q1.peek();
        }
        // Transfer all the elements of q1 to q2 except the last one.
        while (q1.size() != 1) {
            temp = q1.remove();
            q2.add(temp);
        }
        // Store the last element of q1 in a variable.
        int data = q1.remove();
        // Transfer all the elements of q2 to q1.
        while (!q2.isEmpty()) {
            temp = q2.remove();
            q1.add(temp);
        }
        // Add the last element back to q1.
        q1.add(data);
        return data;
    }

    // This function will check if the Stack is empty or not.
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        _15_ImplementStackUsingQueues stack = new _15_ImplementStackUsingQueues();
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