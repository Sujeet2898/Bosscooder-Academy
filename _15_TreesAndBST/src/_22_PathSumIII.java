/*
Question: Path Sum III
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

Constraints:
The number of nodes in the tree is in the range [0, 1000].
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
 */

public class _22_PathSumIII {

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
    // Time complexity of pathSum() is O(n^2), where n is the number of nodes in the binary tree. The reason for this is that for each node in the binary tree, the pathSumHelper() method is called, which has a time complexity of O(n) in the worst case. Thus, the overall time complexity is O(n^2) because we're visiting each node in the binary tree once and performing O(n) operations on each node.
    // Space complexity of pathSum() is O(h), where h is the height of the binary tree. The reason for this is that we're maintaining a call stack of recursive function calls to pathSumHelper() that is equal to the height of the binary tree. In the worst case, where the binary tree is a skewed tree, the height is O(n), and the space complexity is O(n). In the best case, where the binary tree is a balanced tree, the height is O(log n), and the space complexity is O(log n).

    static int counter = 0;
    public static int pathSum(TreeNode root, int sum) {
        // If root is null, there are no paths to check, so return 0.
        if (root == null) return 0;

        // Call pathSumHelper to check for valid paths starting from the current root node.
        // Then, recursively call pathSum on the left and right subtrees of the root node.
        pathSumHelper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        // Return the total number of valid paths found.
        return counter;
    }

    static void pathSumHelper(TreeNode root, int sum, int currentSum) {
        // If the current root is null, we've reached the end of a path and can return.
        if (root == null) {
            return;
        }

        // Add the current node's value to the running total of the path.
        currentSum += root.val;

        // If the running total matches the target sum, increment the counter.
        if (currentSum == sum) {
            counter++;
        }

        // Recursively call pathSumHelper on the left and right subtrees.
        pathSumHelper(root.left, sum, currentSum);
        pathSumHelper(root.right, sum, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        int sum = 8;
        int pathCount = pathSum(root, sum);
        System.out.println("Number of paths with sum " + sum + ": " + pathCount);
        // Output: Number of paths with sum 8: 3
    }
}
