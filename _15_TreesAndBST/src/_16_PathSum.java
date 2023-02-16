/*
Question: Path Sum
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
 */

public class _16_PathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Time complexity: O(n), where n is the number of nodes in the binary tree. This is because in the worst case, the function may need to traverse all the nodes of the binary tree to determine if a path with the given sum exists.
    // Space complexity: O(n). This is because the function may create a recursive call stack that can store at most n function calls. Each function call has its own set of variables and parameters, so the total memory used by the function is proportional to the number of function calls in the call stack.
    // Note that the space complexity can be reduced to O(h) where h is the height of the binary tree, by using an iterative approach instead of a recursive approach. In an iterative approach, we can use a stack or a queue to keep track of the nodes to be processed, so we don't need to keep all the function calls in the call stack.

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // If the root is null, the sum can't be achieved
        if(root == null) {
            return false;
        }

        // If the root is a leaf node and its value matches the target sum, the path sum has been achieved
        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        // Recursively check the left and right subtrees of the root
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        boolean hasPath = hasPathSum(root, targetSum);
        System.out.println("The tree " + (hasPath ? "has" : "does not have") + " a path with sum " + targetSum);
        //  The tree has a path with sum 22

        /*
        5
       / \
      4   8
     /   / \
   11   13  4
  / \        \
 7   2        1
The hasPathSum method is called with the root of the tree and the target sum of 22. The method returns true because there's a path in the tree (5 -> 4 -> 11 -> 2) that adds up to 22. The main method prints "The tree has a path with sum 22".
         */
    }
}
