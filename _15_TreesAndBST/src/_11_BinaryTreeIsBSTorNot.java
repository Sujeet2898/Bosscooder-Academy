/*
Question: A program to check if a Binary Tree is BST or not
A binary search tree (BST) is a node-based binary tree data structure that has the following properties.

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Each node (item in the tree) has a distinct key.
 */

public class _11_BinaryTreeIsBSTorNot {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(n), where n is the number of nodes in the binary tree. This is because we visit each node in the tree exactly once and perform constant time operations on each node.
    // Space complexity: O(h), where h is the height of the binary tree. This is because the function uses a recursive approach and each recursive call adds a new stack frame to the call stack. The maximum height of the call stack is the height of the binary tree. In the worst case, the binary tree is skewed, and the height is equal to the number of nodes, so the space complexity becomes O(n). However, in the average case, the binary tree is balanced, and the height is proportional to the logarithm of the number of nodes, so the space complexity is O(log n).
    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, null, null);
    }

    private static boolean isBSTHelper(TreeNode node, Integer min, Integer max) {
        // Base case: if node is null, return true
        if (node == null) {
            return true;
        }

        // If node's value is outside the allowed range, return false
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Recursively check the left and right subtrees with updated min/max values
        return isBSTHelper(node.left, min, node.val) && isBSTHelper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Create a sample binary tree that is a BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Check if it is a BST
        boolean isBST = isBST(root);
        System.out.println("Is the binary tree a BST? " + isBST); // Is the binary tree a BST? true

        // Create a sample binary tree that is not a BST
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(6);

        // Check if it is a BST
        boolean isBST2 = isBST(root2);
        System.out.println("Is the binary tree a BST? " + isBST2);  // Is the binary tree a BST? false

    }
}
