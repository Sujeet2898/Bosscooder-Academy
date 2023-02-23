/*
Question: Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class _19_SumRootToLeafNumbers {

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

    // Recursive DFS
    // Time Complexity: O(N). Each node is visited once.
    // Space Complexity: O(H). Stack space. In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N). N = Total number of nodes in the tree. H = Height of the tree.
    public static int sumNumbers1(TreeNode root) {
        // If the root is null, there are no paths to add up, so return 0
        if (root == null) {
            return 0;
        }

        // Call the recursive helper function with the root node and an initial accumulated value of 0
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(TreeNode node, int curVal) {
        // If the current node is null, there are no paths to add up, so return 0
        if (node == null) {
            return 0;
        }

        // Calculate the current accumulated value by multiplying the previous accumulated value by 10 and adding the current node's value
        curVal = curVal * 10 + node.val;

        // If the current node is a leaf node, return the current accumulated value
        if (node.left == null && node.right == null) {
            return curVal;
        }

        // Recursively calculate the sum of all root-to-leaf paths in the left and right subtrees and add them together
        return sumNumbersHelper(node.left, curVal) + sumNumbersHelper(node.right, curVal);
    }

    // Iterative Post-Order Traversal
    // Time Complexity: O(N). Each node is visited once.
    // Space Complexity: O(H). Stack space. In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N). N = Total number of nodes in the tree. H = Height of the tree.

    // This method takes a TreeNode called "root" as input and returns an integer.
    public static int sumNumbers2(TreeNode root) {
// If the root is null, return 0.
        if (root == null) {
            return 0;
        }
        // Create a Stack of TreeNodes called "stack" and initialize variables "curVal" and "sum" to 0.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int curVal = 0;
        int sum = 0;

        // While the current node is not null or the stack is not empty, perform the following operations.
        while (cur != null || !stack.isEmpty()) {
            // While the current node is not null, convert the current value to an integer and push it onto the stack. Move left.
            while (cur != null) {
                curVal = curVal * 10 + cur.val;
                stack.push(cur);
                cur = cur.left;
            }

            // Peek at the top of the stack and store the node in the "cur" variable.
            cur = stack.peek();

            // If the right child of the current node is not null and has not been visited yet, move to the right child.
            if (cur.right != null && cur.right != pre) {
                cur = cur.right;
                continue;
            }

            // If the left and right children of the current node are both null, add the current value to the sum.
            if (cur.right == null && cur.left == null) {
                sum += curVal;
            }

            // Pop the node at the top of the stack and set it as the "pre" variable. Divide the current value by 10 and set "cur" to null.
            pre = stack.pop();
            curVal /= 10;
            cur = null;
        }

        // Return the sum of all the integers obtained from the paths from root to leaf nodes in the binary tree.
        return sum;
    }

    public static void main(String[] args) {
        // Create a binary tree with root value 1 and the following structure:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the sum of all root-to-leaf paths in the tree
        int sum1 = sumNumbers1(root);
        int sum2 = sumNumbers2(root);

        // Print the result
        System.out.println("Sum of all root-to-leaf paths: " + sum1);
        System.out.println("Sum of all root-to-leaf paths: " + sum2);
        // Sum of all root-to-leaf paths: 262
        // Sum of all root-to-leaf paths: 262
    }
}
