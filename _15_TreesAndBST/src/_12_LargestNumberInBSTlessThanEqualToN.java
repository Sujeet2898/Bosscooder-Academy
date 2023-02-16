/*
Question: Largest number in BST which is less than or equal to N
We have a binary search tree and a number N. Our task is to find the greatest number in the binary search tree that is less than or equal to N. Print the value of the element if it exists otherwise print -1.
 */

public class _12_LargestNumberInBSTlessThanEqualToN {

    // Time complexity: O(h), where h is the height of the binary search tree. This is because the method traverses down the tree from the root node, visiting at most one child node per level, until it finds the greatest number that is less than or equal to the given value or reaches a leaf node. The worst-case time complexity occurs when the tree is skewed, in which case h = n (the number of nodes), resulting in a time complexity of O(n). However, in a balanced tree, the height is O(log n), resulting in a time complexity of O(log n).
    // Space complexity: O(1), because we use only a constant amount of extra space for the variables used within the method. Specifically, we use space for the result variable and the loop variable root, and these variables do not scale with the size of the input. Therefore, the space complexity is constant and does not depend on the number of nodes in the tree.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // This method takes in the root of a binary search tree and an integer N, and returns the greatest number in the tree that is less than or equal to N.
    public static int findGreatestLessThanOrEqual(TreeNode root, int N) {
        // Initialize the result variable to -1, which will be returned if there is no such number in the tree.
        int result = -1;
        // Enter a while loop that continues as long as the current node is not null.
        while (root != null) {
            // If the current node's value is less than or equal to N, update the result variable and move to the right child.
            if (root.val <= N) {
                result = root.val;
                root = root.right;
            } else {
                // If the current node's value is greater than N, move to the left child.
                root = root.left;
            }
        }
        // Return the result variable, which contains the greatest number in the tree that is less than or equal to N.
        return result;
    }

    public static void main(String[] args) {
        // Example tree:        6
        //                     / \
        //                    4   9
        //                   / \   \
        //                  2   5   12
        //                 /       / \
        //                1       10  15

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(12);
        root.right.right.left = new TreeNode(10);
        root.right.right.right = new TreeNode(15);

        int N = 7;
        int result = findGreatestLessThanOrEqual(root, N);
        System.out.println("The greatest number in the tree that is less than or equal to " + N + " is " + result);   // 6
    }
}
