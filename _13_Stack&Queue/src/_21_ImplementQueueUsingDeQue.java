/*
In this implementation, we use a double-ended queue (dequeue) implemented as a linked list. The enqueue method adds an element to the end of the queue in O(1) time, and the dequeue method removes and returns the first element in O(1) time.
This implementation is straightforward and efficient, with a time complexity of O(1) for both enqueue and dequeue operations.
The time complexity of the enqueue operation is O(1). This means that adding an element to the end of the queue takes constant time, regardless of the number of elements already in the queue.
The time complexity of the dequeue operation is also O(1). This means that removing and returning the first element from the queue takes constant time, regardless of the number of elements in the queue.
The space complexity of this implementation is O(n), where n is the number of elements in the queue. This means that the amount of memory required by the queue grows linearly with the number of elements in the queue. This is because we need to store the elements in the queue, and each element requires a fixed amount of memory.
 */
import java.util.LinkedList;

public class _21_ImplementQueueUsingDeQue {
    LinkedList<Integer> deque;

    // Initialize the deque
    public _21_ImplementQueueUsingDeQue() {
        deque = new LinkedList<>();
    }

    // Add an element to the end of the queue in O(1) time
    public void enqueue(int element) {
        deque.addLast(element);
    }

    // Remove and return the first element in O(1) time
    public int dequeue() {
        return deque.removeFirst();
    }

    public static void main(String[] args) {
        _21_ImplementQueueUsingDeQue queue = new _21_ImplementQueueUsingDeQue();

        // Add elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Remove and print elements from the queue
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.dequeue()); // Output: 3
    }
}