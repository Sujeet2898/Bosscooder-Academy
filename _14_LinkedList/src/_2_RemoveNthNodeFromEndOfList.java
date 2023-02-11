/*
Question: Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []

Input: head = [1,2], n = 1
Output: [1]
 */

// Java program to remove the nth node from the end of a linked list

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class LinkedList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to serve as the new head of the linked list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Create two pointers, fast and slow, both starting at the dummy node
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer n steps forward
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers forward until fast reaches the end of the linked list
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end of the linked list
        slow.next = slow.next.next;

        // Return the new head of the linked list
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode newHead = removeNthFromEnd(head, n);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
/*
Output:
1
2
3
5
 */