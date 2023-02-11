/*
Question: Intersection of Two Linked Lists
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.
For example, the following two linked lists begin to intersect at node c1:
A:         a1-->a2-->
                     c1-->c2-->c3
B:    b1-->b2-->b3-->
The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Note that the linked lists must retain their original structure after the function returns.
Custom Judge:
The inputs to the judge are given as follows (your program is not given these inputs):
* intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
* listA - The first linked list.
* listB - The second linked list.
* skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
* skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
If you correctly return the intersected node, then your solution will be accepted.
-----------------------------------------------------------------------------------------------
Example 1:
A:        4-->1-->
                  8-->4-->5
B:    5-->6-->1-->
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the
intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B)
are different node references. In other words, they point to two different locations in memory, while the nodes with
value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
Example 2:
A:    1-->9-->1-->
                  2-->4
B:            3-->
Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the
intersected node in A; There are 1 node before the intersected node in B.
 */

public class _3_IntersectionOfTwoLinkedLists {

    // Time complexity: O(n), where n is the total number of nodes in both linked lists. This is because, in the worst case, both d1 and d2 will traverse all nodes in both linked lists.
    // Space complexity: O(1), as it uses only two extra pointers, d1 and d2, which do not consume any extra memory proportional to the size of the linked lists.

    /*
    Intuition:
The above approach uses two pointers, d1 and d2, that traverse the two linked lists simultaneously. The idea is to make the pointers meet at the intersection node, if it exists. If the linked lists have no intersection, then the pointers will end up being null at the same time.
Here's how the approach works:
If d1 reaches the end of linked list headA, it switches to linked list headB.
If d2 reaches the end of linked list headB, it switches to linked list headA.
This way, if the linked lists have an intersection, both d1 and d2 will eventually reach the intersection node and stop at the same time.
If the linked lists have no intersection, d1 and d2 will reach the end of both linked lists at the same time and stop.
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // d1 and d2 are dummy nodes, pointing to the heads of the linked lists headA and headB.
        ListNode d1 = headA, d2 = headB;

        // Keep looping until d1 and d2 are equal, or either of them is null.
        while(d1 != d2){
            // If d1 is null, set it to headB.
            if(d1 == null){
                d1 = headB;
            }
            // If d1 is not null, move to the next node.
            else{
                d1 = d1.next;
            }

            // If d2 is null, set it to headA.
            if(d2 == null){
                d2 = headA;
            }
            // If d2 is not null, move to the next node.
            else{
                d2 = d2.next;
            }
        }

        // When d1 and d2 are equal, return either d1 or d2.
        return d1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(5);
        headA.next.next.next = new ListNode(7);
        headA.next.next.next.next = new ListNode(9);
        headA.next.next.next.next.next = new ListNode(11);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(4);
        headB.next.next = headA.next.next.next.next;

        ListNode result = getIntersectionNode(headA, headB);
        if (result == null) {
            System.out.println("The linked lists do not have an intersection");
        } else {
            System.out.println("The linked lists have an intersection at node " + result.val);
        }
        // output: The linked lists have an intersection at node 9
    }
}
