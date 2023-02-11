/*
Question: Flatten a Multilevel Doubly Linked List
You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

Input: head = [1,2,null,3]
Output: [1,3,2]
 */

public class _8_FlattenMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    // Time complexity: O(n) where n is the total number of nodes in the linked list. Each node in the linked list is visited once in the flatten function. For each node, the raiseChild function is called if it has a child. The raiseChild function finds the leftmost and rightmost nodes in the child linked list in linear time, i.e., O(n) time complexity where n is the number of nodes in the child linked list. The function then adjusts the pointers between the current node, the child linked list, and the next node in the main linked list, which takes constant time for each node.
    // Space complexity: O(1) as it only uses a constant amount of memory to store pointers to the linked list nodes. No additional data structures are used, and the original linked list is modified in-place.
    public Node flatten (Node head) {
        Node node = head;  // initialize the node with the head of the doubly linked list
        while (node != null) {  // loop through the linked list until the node is null
            if (node.child != null) raiseChild(node);  // if the node has a child, call the raiseChild method
            node = node.next;  // move to the next node
        }
        return head;  // return the head of the linked list
    }

    private void raiseChild(Node node) {
        Node left = node.child;  // initialize the left node with the child of the current node
        while (left.prev != null) left = left.prev;  // traverse to the leftmost node of the child list

        Node right = node.child;  // initialize the right node with the child of the current node
        while(right.next != null) right = right.next;  // traverse to the rightmost node of the child list

        Node oldNext = node.next;  // save the next node of the current node in oldNext
        node.next = left;  // connect the current node with the leftmost node of the child list
        left.prev = node;  // set the previous node of the leftmost node as the current node
        right.next = oldNext;  // connect the rightmost node of the child list with the oldNext node

        if (oldNext != null) oldNext.prev = right;  // if oldNext is not null, set the previous node of oldNext as the rightmost node of the child list
        node.child = null;  // set the child of the current node as null
    }
}
