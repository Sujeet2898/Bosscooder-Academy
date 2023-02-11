/*
Question: Linked List Cycle
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */


public class _4_LinkedListCycle {

    // Time Complexity: O(n), where n is the number of nodes in the linked list. In the worst case, the fast and slow pointers will traverse the entire linked list, which takes O(n) time.
    // Space Complexity: O(1), as it only uses two pointers to traverse the linked list.
    /*
    The intuition behind the fast and slow pointer technique for detecting a cycle in a linked list is as follows:
Two pointers, fast and slow, are created and both initially point to the head of the linked list.
The fast pointer moves two steps ahead with each iteration, while the slow pointer moves only one step ahead.
If there's a cycle in the linked list, the fast pointer will eventually catch up to the slow pointer and both will meet at some point. This happens because the fast pointer is moving twice as fast as the slow pointer.
If there's no cycle in the linked list, the fast pointer will eventually reach the end of the list and the loop will terminate.
If the loop terminates, the function returns false, indicating that there's no cycle in the linked list. If the fast and slow pointers meet, the function returns true, indicating that there's a cycle in the linked list.
By using this technique, we can detect a cycle in a linked list in linear time and constant space.
     */
    public static boolean hasCycle(ListNode head) {

        // Check if the linked list is empty or has only one node
        if(head == null || head.next == null){
            return false;
        }

        // Create two pointers, fast and slow, that point to the head of the linked list
        ListNode fast = head;
        ListNode slow = head;

        // Use a while loop to traverse the linked list
        while(fast.next != null && fast.next.next != null){
            // Move the fast pointer two steps ahead
            fast = fast.next.next;
            // Move the slow pointer one step ahead
            slow = slow.next;

            // If fast and slow pointers meet, it means there's a cycle in the linked list
            if(fast == slow){
                return true;
            }
        }
        // If the loop terminates, it means there's no cycle in the linked list
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        if (hasCycle(head)) {
            System.out.println("The linked list has a cycle");
        } else {
            System.out.println("The linked list does not have a cycle");
        }
        // output: The linked list has a cycle
    }
}
