/*
Question: Path Sum II
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Input: root = [1,2,3], targetSum = 5
Output: []

Input: root = [1,2], targetSum = 0
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _21_PathSumII {

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
    // Time complexity: O(N^2) where N is the number of nodes in the binary tree. This is because in the worst case, we need to traverse every node in the binary tree and each node may be added to the path stack multiple times, resulting in O(N) time complexity for the recursion. In addition, we create a new ArrayList for each valid path, which takes O(N) time in the worst case. Therefore, the overall time complexity is O(N^2).
    // Space complexity: O(N^2) due to the same reason as the time complexity. In the worst case, the recursion depth may be N and the path stack may contain N elements, so the space complexity is O(N). Additionally, we store all valid paths in the resultList, which takes O(N^2) space in the worst case if every path includes all nodes in the binary tree.

    private static List<List<Integer>> resultList = new ArrayList<List<Integer>>();

    public static void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        // Push the current node's value onto the path stack
        path.push(root.val);

        // If the current node is a leaf and the sum matches, add the current path to the result list
        if(root.left == null && root.right == null)
            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));

        // Recursively search the left and right subtrees with the updated sum and path
        if(root.left!=null) pathSumInner(root.left, sum-root.val, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, path);

        // Pop the current node's value from the path stack before returning
        path.pop();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        // If the root is null, return the empty result list
        if(root==null) return resultList;

        // Create a stack to hold the current path and recursively search the tree
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);

        // Return the final result list of all paths with the given sum
        return resultList;
    }

    public static void main(String[] args) {
        // Create a binary tree for testing
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        // Find all root-to-leaf paths with a sum of 22
        List<List<Integer>> resultList = pathSum(root, 22);

        // Print each path in the result list
        for (List<Integer> path : resultList) {
            System.out.println(path);
        }
        // Output: [5, 4, 11, 2]
        //          [5, 8, 4, 5]
    }
}
