/*
Question: Flattening a Linked List
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a
look at the printList() function in the driver code.
Example 1:
Input:
5 -> 10 -> 19 -> 28
|     |     |     |
7     20    22   35
|           |     |
8          50    40
|                 |
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every node in a single level.
(Note: | represents the bottom pointer.)
Example 2:
Input:
5 -> 10 -> 19 -> 28
|          |
7          22
|          |
8          50
|
30
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every node in a single level.
(Note: | represents the bottom pointer.)
 */

public class _7_FlatteningALinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode bottom;

        ListNode(int x) {
            val = x;
            next = null;
            bottom = null;
        }
    }
    public static ListNode flatten(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode cur = root;
        ListNode tail = root;
        while (cur != null) {
            if (cur.bottom != null) {
                tail.next = cur.bottom;
                tail = tail.next;
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
            cur = cur.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(5);
        root.bottom = new ListNode(10);
        root.bottom.bottom = new ListNode(19);
        root.bottom.bottom.next = new ListNode(20);
        root.bottom.bottom.next.bottom = new ListNode(22);
        root.bottom.bottom.next.bottom.bottom = new ListNode(50);
        root.next = new ListNode(28);

        ListNode result = flatten(root);

        ListNode sorted = new ListNode(-1);
        ListNode cur = sorted;
        while (result != null) {
            while (cur.next != null && cur.next.val < result.val) {
                cur = cur.next;
            }
            ListNode next = result.next;
            result.next = cur.next;
            cur.next = result;
            cur = cur.next;
            result = next;
        }

        result = sorted.next;
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        // Output: 5 10 19 20 22 28
    }
}
