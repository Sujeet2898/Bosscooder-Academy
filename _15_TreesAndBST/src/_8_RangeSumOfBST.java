/*
Question: Range Sum of BST
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 */

public class _8_RangeSumOfBST {

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

    // Using DFS
    // Time complexity: O(N), where N is the number of nodes in the tree. This is because the function visits every node in the tree once, and the amount of work done at each node is proportional to the height of the tree. In the worst case, where the tree is not balanced and resembles a linked list, the height of the tree will be N, so the time complexity is O(N)
    // Space complexity: O(H), where H is the height of the tree. This is because the function uses a recursive call stack that has a maximum depth of H. In the worst case, where the tree is not balanced and resembles a linked list, the height of the tree will be N, so the space complexity is O(N).

    public int rangeSumBST(TreeNode root, int low, int high) {
        // If the root is null, return 0
        if(root == null)
            return 0;

        // Check if the root value is within the given range
        if(root.val >= low && root.val <= high)
            // If the root is within the given range, add the sum of left sub-tree, root value, and right sub-tree
            return rangeSumBST(root.left, low, high) + root.val + rangeSumBST(root.right, low, high);
        else if (root.val > high)
            // If the root is greater than the high value, only traverse the left sub-tree
            return rangeSumBST(root.left, low, high);
        else
            // If the root is less than the low value, only traverse the right sub-tree
            return rangeSumBST(root.right, low, high);
    }
}
