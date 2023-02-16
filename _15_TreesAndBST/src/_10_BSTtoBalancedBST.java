/*
Question: Convert a normal BST to Balanced BST
Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30


Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4

 */

import java.util.ArrayList;
import java.util.List;

public class _10_BSTtoBalancedBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Time complexity: O(N), where N is the number of nodes in the input BST, as we need to traverse the BST in inorder to create the sorted list and construct a balanced BST from the sorted list.
    // Space complexity: O(N), as we need to store all the nodes of the BST in the list.

    public static TreeNode balanceBST(TreeNode root) {
        // Step 1: Traverse the BST in inorder and store all the elements in an array
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        // Step 2: Use the sorted array to create a balanced BST
        return constructBalancedBST(list, 0, list.size() - 1);
    }

    // Inorder traversal of the BST to store elements in an array
    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        // Base case: if node is null, return
        if (node == null) {
            return;
        }
        // Recurse on left subtree
        inorderTraversal(node.left, list);
        // Add current node value to list
        list.add(node.val);
        // Recurse on right subtree
        inorderTraversal(node.right, list);
    }

    // Create a balanced BST from the sorted array
    private static TreeNode constructBalancedBST(List<Integer> list, int start, int end) {
        // Base case: if start is greater than end, return null
        if (start > end) {
            return null;
        }
        // Calculate the middle index
        int mid = start + (end - start) / 2;
        // Create a new node with the value at the middle index
        TreeNode node = new TreeNode(list.get(mid));
        // Recursively construct the left subtree using the left half of the list
        node.left = constructBalancedBST(list, start, mid - 1);
        // Recursively construct the right subtree using the right half of the list
        node.right = constructBalancedBST(list, mid + 1, end);
        // Return the new node
        return node;
    }

    public static void main(String[] args) {
        // Create an unbalanced BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        // Convert the unbalanced BST into a balanced BST
        TreeNode balancedRoot = balanceBST(root);

        // Print the inorder traversal of the balanced BST
        printInorderTraversal(balancedRoot);  // 1 2 3 4 5 6 7
    }

    // Helper function to print the inorder traversal of a BST
    private static void printInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorderTraversal(node.left);
        System.out.print(node.val + " ");
        printInorderTraversal(node.right);
    }
}
