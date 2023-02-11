/*
Question: All Elements in Two Binary Search Trees
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _7_AllElementsInTwoBinarySearchTrees {

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

    // Using Stack and Inorder
    // Time complexity: O(m + n), where m is the number of nodes in tree1 and n is the number of nodes in tree2. This is because each node is processed once and only once, and the processing of a node takes constant time, therefore the total time complexity is proportional to the total number of nodes in both trees.
    // Space complexity: O(log m + log n), where m is the maximum depth of tree1 and n is the maximum depth of tree2. This is because the maximum number of nodes stored in the two stacks is proportional to the maximum depth of the two trees.
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Initializing a list to store the result
        List<Integer> res = new ArrayList<>();

        // Stack to store nodes of first binary search tree
        Stack<TreeNode> stack1 = new Stack<>();

        // Stack to store nodes of second binary search tree
        Stack<TreeNode> stack2 = new Stack<>();

        // The loop will run until both stacks are empty and both roots are null
        while (!stack1.isEmpty() || root1 != null || !stack2.isEmpty() || root2 != null) {
            // Go to the leftmost node of the first binary search tree
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            // Go to the leftmost node of the second binary search tree
            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            // Perform operation in inorder area: Compare the top elements of both stacks, and add the smaller value to the result list
            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val < stack2.peek().val && !stack2.isEmpty())) {
                TreeNode cur1 = stack1.pop();
                res.add(cur1.val);
                root1 = cur1.right;
            }
            else {  //just the opposite case is followed  here
                TreeNode cur2 = stack2.pop();
                res.add(cur2.val);
                root2 = cur2.right;
            }
        }

        // Return the result list: elements in sored order
        return res;
    }
}
