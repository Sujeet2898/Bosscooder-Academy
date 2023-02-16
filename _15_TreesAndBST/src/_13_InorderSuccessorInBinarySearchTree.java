/*
Question: Inorder Successor in Binary Search Tree
Example 1:

   5
  / \
 3   7
    / \
   6   9
In this example, the given node is the root node with value 5. The inorder successor of 5 is the node with value 6. We can see that 6 is the next node in the inorder traversal of the binary search tree after 5.

Example 2:

   3
  / \
 2   4
In this example, the given node is the left child of the root with value 2. The inorder successor of 2 is the node with value 3. Again, we can see that 3 is the next node in the inorder traversal of the binary search tree after 2.

Example 3:

   7
  / \
 5   8
    / \
   6   9
        \
         10
In this example, the given node is the right child of the node with value 9. The inorder successor of 9 is the node with value 10. This is because 10 is the next node in the inorder traversal of the binary search tree after 9. Note that the right subtree of 9 does not have any left children, so the inorder successor of 9 is the leftmost node of the right subtree.
If the given node is the largest node in the binary search tree, there is no inorder successor. Similarly, if the given node is not in the binary search tree, the function will return null.
 */

public class _13_InorderSuccessorInBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(h), where h is the height of the binary search tree. This is because in the worst case, we may need to traverse from the root to the deepest leaf node to find the inorder successor of a given node.
    // Space complexity: O(1). This is because we are only using a constant amount of additional space to store the curr and successor variables, as well as the loop counters.
    // Note that if the binary search tree is unbalanced, the height of the tree may be as large as O(n), where n is the number of nodes in the tree. In this case, the time complexity of the inorderSuccessor function would be O(n). However, if the tree is balanced, the height would be O(log n), and the time complexity would be O(log n).

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // If p has a right child, the inorder successor is the leftmost node in the right subtree
        if (p.right != null) {
            // Set the current node to the right child of p
            TreeNode curr = p.right;
            // Find the leftmost node in the right subtree
            while (curr.left != null) {
                curr = curr.left;
            }
            // Return the leftmost node in the right subtree
            return curr;
        }
        // If p does not have a right child, the inorder successor is the lowest ancestor whose left child is also an ancestor
        else {
            // Initialize the successor to null
            TreeNode successor = null;
            // Traverse the tree
            while (root != null) {
                // If p's value is less than the current node's value, set the successor to the current node and move to the left child
                if (p.val < root.val) {
                    successor = root;
                    root = root.left;
                }
                // If p's value is greater than the current node's value, move to the right child
                else if (p.val > root.val) {
                    root = root.right;
                }
                // If p's value is equal to the current node's value, break out of the loop
                else {
                    break;
                }
            }
            // Return the lowest ancestor whose left child is also an ancestor of p
            return successor;
        }
    }

    public static void main(String[] args) {
        // Create a binary search tree.
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Find the inorder successor of a node.
        TreeNode node = root.left.right;
        TreeNode successor = inorderSuccessor(root, node);

        // Print the value of the inorder successor, or -1 if it does not exist.
        if (successor != null) {
            System.out.println("Inorder successor of " + node.val + " is " + successor.val);
        } else {
            System.out.println("Inorder successor of " + node.val + " does not exist.");
        }

        // Inorder successor of 4 is 5
    }
}
