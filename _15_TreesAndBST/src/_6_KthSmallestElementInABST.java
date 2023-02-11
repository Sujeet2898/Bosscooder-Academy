/*
Question: Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */

public class _6_KthSmallestElementInABST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Using Count variable and Iterative Inorder Traversal
    // Time complexity: O(N), where N is the number of nodes in the BST. This is because the in-order traversal visits each node exactly once.
    // Space complexity: O(log N) on average and O(N) in the worst case, where N is the number of nodes in the BST. This is because the in-order traversal recursively calls itself and consumes space on the call stack, which is proportional to the height of the BST. In a balanced BST, the height is log N, so the space complexity is O(log N). In the worst case, when the BST is skewed, the height is N, and the space complexity is O(N).

    private int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        // Initializing the count to 0
        count = 0;
        // Calling the helper method to traverse the BST in in-order fashion
        inorderTraversal(root, k);
        // Returning the result after traversing the BST
        return res;
    }

    public void inorderTraversal(TreeNode root, int k){
        // Base case, if the root is null, return
        if(root == null) return;
        // Traverse the left subtree
        inorderTraversal(root.left, k);
        // Increment the count by 1
        count++;
        // If count is equal to k, update the result with the value of the current node
        if(count == k) res = root.val;
        // Traverse the right subtree
        inorderTraversal(root.right, k);
    }
}
