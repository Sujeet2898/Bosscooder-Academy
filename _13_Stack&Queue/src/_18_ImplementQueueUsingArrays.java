/*
In this implementation, we are using an array to store the elements of the queue. The enqueue method adds elements to the end of the queue and the dequeue method removes the front element of the queue.
To handle the overflow and underflow conditions, we have used modulo operation % on rear and front indices. The front method returns the front element of the queue and the isEmpty method returns true
if the queue is empty, false otherwise. The isFull method returns true if the queue is full, false otherwise.
The time complexity of the enqueue operation in a queue implemented using arrays is O(1) on average. This is because adding an element to the end of the queue takes constant time, assuming that the array is not full and needs to be resized.
The time complexity of the dequeue operation is also O(1) on average. This is because removing the front element of the queue and returning it takes constant time.
The space complexity of the queue implemented using arrays is O(n), where n is the number of elements in the queue. This is because the size of the array used to store the elements of the queue must be large enough to hold all of the elements. In the worst case, the size of the array may need to be resized to accommodate a larger number of elements, which takes O(n) time.
 */
public class _18_ImplementQueueUsingArrays {
    private int[] queue; // array to store the elements of the queue
    private int front; // index of the front of the queue
    private int rear; // index of the end of the queue
    private int size; // number of elements in the queue

    // constructor to initialize the queue with a given capacity
    public _18_ImplementQueueUsingArrays(int capacity) {
        queue = new int[capacity];
        front = rear = 0;
        size = 0;
    }

    // inserts an element at the end of the queue
    public void enqueue(int item) {
        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    // removes and returns the front element of the queue
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    // returns the front element of the queue
    public int front() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // returns true if the queue is full, false otherwise
    public boolean isFull() {
        return size == queue.length;
    }

    public static void main(String[] args) {
        _18_ImplementQueueUsingArrays queue = new _18_ImplementQueueUsingArrays(5);
        // insert elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Front element is: " + queue.front());
        System.out.println("Dequeued element is: " + queue.dequeue());

        System.out.println("Queue is empty: " + queue.isEmpty());
        System.out.println("Queue is full: " + queue.isFull());
    }
/*
Front element is: 1
Dequeued element is: 1
Queue is empty: false
Queue is full: false
 */
}