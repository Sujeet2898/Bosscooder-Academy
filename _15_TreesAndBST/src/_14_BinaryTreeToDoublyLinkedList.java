/*
Question: Binary Tree to Doubly Linked List
Given a Binary Tree, The task is to convert it to a Doubly Linked List keeping the same order.

The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
The order of nodes in DLL must be the same as in Inorder for the given Binary Tree.
The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

Example 1:

Binary tree:
        1
       / \
      2   3
Doubly linked list:
1 <=> 2 <=> 3

Example 2:

Binary tree:
         4
        / \
       2   5
      / \
     1   3
Doubly linked list:
1 <=> 2 <=> 3 <=> 4 <=> 5

Example 3:

Binary tree:
        5
       / \
      2   7
     / \   \
    1   4   9
         \
          6
Doubly linked list:
1 <=> 2 <=> 4 <=> 5 <=> 6 <=> 7 <=> 9
 */

public class _14_BinaryTreeToDoublyLinkedList {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode convertToDoublyLinkedList(TreeNode root) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }

        // Recursively convert left and right subtrees to doubly linked lists
        TreeNode leftHead = convertToDoublyLinkedList(root.left);
        TreeNode rightHead = convertToDoublyLinkedList(root.right);

        // Detach root from the rest of the tree
        root.left = null;
        root.right = null;

        // Merge left and right doubly linked lists with root as the middle node
        if (leftHead != null) {
            // Find the last node in the left doubly linked list
            TreeNode leftTail = getTail(leftHead);

            // Connect the last node in the left doubly linked list to root
            leftTail.right = root;
            root.left = leftTail;
        }
        if (rightHead != null) {
            // Connect the root node to the head of the right doubly linked list
            rightHead.left = root;
            root.right = rightHead;
        }

        // Return the head of the resulting doubly linked list
        return leftHead != null ? leftHead : root;
    }

    private static TreeNode getTail(TreeNode node) {
        // Traverse to the rightmost node of the doubly linked list
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Convert the binary tree to a doubly linked list
        TreeNode head = convertToDoublyLinkedList(root);

        // Traverse the doubly linked list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        // Output: 1 2 3 4 5
    }
}
