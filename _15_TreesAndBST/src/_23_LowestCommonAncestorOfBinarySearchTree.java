/*
Question: Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
 */

public class _23_LowestCommonAncestorOfBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Depth-first search (DFS) approach
    // Time complexity: O(h), where h is the height of the BST. This is because in the worst case, we may need to traverse the height of the tree to reach the LCA.
    // Space complexity: O(h), because the maximum number of function calls on the call stack at any given time is equal to the height of the tree. This is because the method is recursive, so each recursive call adds a new function call to the call stack.

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null, we have reached the end of the BST and the LCA does not exist
        if (root == null) return null;
        // If both p and q are less than the root, the LCA must be in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than the root, the LCA must be in the right subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If p and q are on different sides of the root, the LCA must be the root
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // Create a binary search tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Find the lowest common ancestor of two nodes
        TreeNode p = root.left.right.left;
        TreeNode q = root.left.right.right;
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("The lowest common ancestor of " + p.val + " and " + q.val + " is " + lca.val);
        // Output: The lowest common ancestor of 3 and 5 is 4
    }
}
