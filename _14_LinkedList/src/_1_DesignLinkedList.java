/*
Question: Design Linked List
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 */

class MyLinkedList {
    // Inner class to represent a node in the linked list
    class Node {
        int val;
        Node next;

        // Constructor to initialize a node with a given value
        Node(int val) {
            this.val = val;
        }
    }

    // Head node of the linked list
    Node head;
    // Size of the linked list
    int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        // Initialize the head node as null
        this.head = null;
        // Initialize the size as 0
        this.size = 0;
    }

    /**
     * get(int index): This function retrieves the value of the node at the given index.
     * Time Complexity: O(n), where n is the number of nodes in the linked list. This is because we have to traverse the linked list to find the node at the given index.
     * Space Complexity: O(1), as we only use a constant amount of space to store temporary variables during the iteration.
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        // Check if the index is less than 0 or greater than or equal to the size of the linked list
        if (index < 0 || index >= size) return -1;
        // Start from the head node
        Node cur = head;
        // Traverse the linked list to the index-th node
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        // Return the value of the index-th node
        return cur.val;
    }

    /**
     * addAtHead(int val): This function adds a new node with the given value to the front of the linked list.
     * Time Complexity: O(1), as we only need to update the head pointer and increment the size.
     * Space Complexity: O(1), as we only use a constant amount of space to create a new node and store its value.
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // Create a new node with the given value
        Node newHead = new Node(val);
        // Set the next node of the new node to the current head node
        newHead.next = head;
        // Set the new node as the head node
        head = newHead;
        // Increase the size of the linked list
        size++;
    }

    /**
     * addAtTail(int val): This function adds a new node with the given value to the end of the linked list.
     * Time Complexity: O(n), where n is the number of nodes in the linked list. This is because we have to traverse the linked list to find the tail node.
     * Space Complexity: O(1), as we only use a constant amount of space to create a new node and store its value.
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        // Start from the head node
        Node cur = head;
        // If the linked list is empty, set the new node as the head node
        if (cur == null) {
            head = new Node(val);
        } else {
            // Traverse the linked list to the last node
            while (cur.next != null) {
                cur = cur.next;
            }
            // Set the next node of the last node to the new node
            cur.next = new Node(val);
        }
        // Increase the size of the linked list
        size++;
    }

    /**
     * addAtIndex(int index, int val): This function adds a new node with the given value to the list before the node at the given index.
     * Time Complexity: O(n), where n is the number of nodes in the linked list. This is because we have to traverse the linked list to find the node before the given index.
     * Space Complexity: O(1), as we only use a constant amount of space to create a new node and store its value.
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // If the index is less than or equal to 0, add the node to the head
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        // If the index is equal to the size, add the node to the tail
        if (index == size) {
            addAtTail(val);
            return;
        }
        // If the index is greater than the size, do not insert the node
        if (index > size) return;
        // Initialize a current node to head
        Node cur = head;
        // Iterate to the node before the index
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        // Create a new node with the given value
        Node newNode = new Node(val);
        // Set the next node of the new node to be the next node of the current node
        newNode.next = cur.next;
        // Set the next node of the current node to be the new node
        cur.next = newNode;
        // Increase the size of the linked list
        size++;
    }

    /**
     * deleteAtIndex(int index): This function removes the node at the given index, if the index is valid.
     * Time Complexity: O(n), where n is the number of nodes in the linked list. This is because we have to traverse the linked list to find the node before the given index.
     * Space Complexity: O(1), as we only use a constant amount of space to store temporary variables during the iteration.
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        // If the index is less than 0 or greater than or equal to size, return
        if (index < 0 || index >= size) return;
        // If the index is 0, set the head to the next node and decrease the size
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        // Initialize a current node to head
        Node cur = head;
        // Iterate to the node before the index
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        // Set the next node of the current node to be the next node of the next node of the current node
        cur.next = cur.next.next;
        // Decrease the size of the linked list
        size--;
    }
}