/*
Question: Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [1,2,3]
Input: root = []
Output: []
Input: root = [1]
Output: [1]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Node -> Left -> Right
public class _2_PreorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int data) {
            this.val = data;
            left = null;
            right = null;
        }
    }

    // 1. Using Recursion
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(N) --> Space is needed for the recursion stack.

    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, ArrayList<Integer> list){
        if(node != null){
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }

    // 2. Iterative Approach
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(N) -->  In the worst case, (a tree with every node having a single right child and left-subtree

    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            if(curr != null) {
                stack.push(curr); // Push the current node.

                // only one change from inOrder to preOrder
                list.add(curr.val); // Add the current value to the list before going to children.

                curr = curr.left;  // Continue to explore the left subtree.
            }

            // Encountered a left child with a null value. Pop the root node.
            else{
                curr = stack.pop(); // Root of the subtree.
                curr = curr.right; // Go explore the right subtree.
            }
        }
        return list;
    }

    // 3. Morris Preorder Traversal of a Binary tree
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(1) --> We are not using recursion.

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        while(curr != null){
            // If we don't have left child, simply add root and traverse on right
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }

            // If we do have left child, so we need to first make a path then only we can come back to root after finishing this subtree's inorder traversal
            else {
                TreeNode predecessor = curr.left; //mark the left child

                //go to right till we get extreme right node
                while(predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                // if pre.right is null then link it to current to reach back
                if(predecessor.right == null){
                    predecessor.right = curr; // firstly make the thread
                    list.add(curr.val);  // only one change from inOrder to preOrder
                    curr = curr.left;
                }
                //pre.right is current meaning the left tree has been traversed so remove the link and traverse the right subtree now
                if(predecessor.right == curr) {
                    predecessor.right = null; // firstly cut the thread
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}