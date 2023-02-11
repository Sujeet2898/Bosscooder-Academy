/*
Question: Copy List with Random Pointer
A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has
its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should
point to new nodes in the copied list such that the pointers in the original list and copied list represent the same
list state. None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
two nodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.
The linked list is represented in the input/output as a list of n nodes.
Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 */



public class _6_CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Object random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {

        // First, the code creates a copy of each node and links them together side-by-side in a single list.
        Node iter = head; // create a reference to the current node in the original linked list
        while (iter != null) { // iterate over the original linked list until there are no more nodes
            Node copy = new Node(iter.val, iter.next); // create a new node with the same value as the current node
            iter.next = copy; // change the next pointer of the current node to point to the newly created node
            iter = copy.next; // move the reference to the next node in the original linked list
        }

        // Second, the code assigns the random pointers for the copy nodes.
        iter = head; // reset the reference to the head of the original linked list
        while (iter != null) { // iterate over the original linked list again
            if (iter.random != null) { // if the current node has a random pointer
                iter.next.random = iter.random.next; // set the random pointer of the corresponding copy node to the next node of the random node
            }
            iter = iter.next.next; // move the reference to the next node in the original linked list (skipping the copy node)
        }

        // Finally, the code restores the original list and extracts the copy list
        iter = head; // reset the reference to the head of the original linked list
        Node pseudoHead = new Node(0, null); // create a dummy node as the head of the copied linked list
        Node copy = pseudoHead; // create a reference to the current node in the copied linked list
        while (iter != null) { // iterate over the original linked list
            copy.next = iter.next; // set the next pointer of the current node in the copied linked list to the next node in the original linked list
            copy = copy.next; // move the reference to the next node in the copied linked list
            iter.next = copy.next; // set the next pointer of the current node in the original linked list to the next node in the original linked list (skipping the copy node)
            iter = iter.next; // move the reference to the next node in the original linked list
        }

        return pseudoHead.next; // return the head of the copied linked list (skipping the dummy node)
    }

    public static void main(String[] args) {
        Node head1 = new Node(7, null);
        head1.next = new Node(13, null);
        head1.next.next = new Node(11, null);
        head1.next.next.next = new Node(10, null);
        head1.next.next.next.next = new Node(1, null);

        // set the random pointers of each node
        head1.random = head1.next.next.next;
        head1.next.random = head1.next.next;
        head1.next.next.random = head1.next.next.next.next;
        head1.next.next.next.random = head1.next;
        head1.next.next.next.next.random = head1;

        Node copiedList = copyRandomList(head1);

        // Print the copied linked list to verify that it has the same values and pointers as the original linked list
        Node iter = copiedList;
        while (iter != null) {
            System.out.print("[Val: " + iter.val + ", Random: " + (iter.random == null ? "null" : iter.random.val) + "] -> ");
            iter = iter.next;
        }
        System.out.println("null");
    }
}
