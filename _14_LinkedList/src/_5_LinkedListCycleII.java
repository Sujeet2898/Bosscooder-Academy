/*
Question: Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 */


public class _5_LinkedListCycleII {

    // Time complexity: O(n), where n is the number of nodes in the linked list. This is because in the worst-case scenario, the fast and slow pointers will traverse the entire linked list before finding the cycle or determining that there is no cycle.
    // Space complexity: O(1), because it only uses a constant amount of extra space for the three pointers (fast, slow, and entry). These pointers do not depend on the size of the linked list, so the space complexity remains constant.
    /*
    The intuition behind the detectCycle method is based on the concept of two pointers with different speeds. The method uses two pointers, fast and slow, that traverse the linked list. The fast pointer moves two steps forward for every one step that the slow pointer takes.
If there is a cycle in the linked list, the fast and slow pointers will eventually meet at the same node. This is because the fast pointer will have traversed the cycle more quickly and will eventually catch up to the slow pointer.
Once the fast and slow pointers meet, the method uses a third pointer, entry, that starts at the head of the linked list. Both the slow pointer and the entry pointer move one step at a time until they meet at the same node. This node is the starting point of the cycle.
The intuition of this method works because when the fast and slow pointers meet, they will have traversed a total of k + x steps, where k is the length of the cycle and x is the distance from the start of the cycle to the meeting point of the fast and slow pointers. At this point, the slow pointer will have traveled a total of x steps, so if the entry pointer also starts at x steps from the start of the cycle, it will also meet the slow pointer at the start of the cycle.
     */
    public static ListNode detectCycle(ListNode head) {
        // If the linked list is empty or has only one node, return null as there cannot be a cycle
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;   // Create two pointers, fast and slow
        ListNode slow = head;
        ListNode entry = head;  // Create a pointer, entry, that will be used to traverse the linked list

        // Continue the loop as long as fast's next node and fast's next's next node are not null
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;  // Move the fast pointer two steps forward
            slow = slow.next;  // Move the slow pointer one step forward

            // If the fast and slow pointers are pointing to the same node, there is a cycle in the linked list
            if(fast == slow){
                // Move both slow and entry pointers one step at a time until they are pointing to the same node
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                // Return the node that both slow and entry pointers are pointing to
                return slow;
            }
        }
        // If there is no cycle, return null
        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;  // cycle starts from node 3

        ListNode result = detectCycle(n1);

        if (result != null) {
            System.out.println("The starting node of the cycle is: " + result.val);
        } else {
            System.out.println("The linked list does not have a cycle.");
        }
        // Output: The starting node of the cycle is: 3
    }
}
