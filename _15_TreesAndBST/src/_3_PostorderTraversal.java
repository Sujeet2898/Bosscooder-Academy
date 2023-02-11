/*
Question: Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes' values.
Input: root = [1,null,2,3]
Output: [3,2,1]
Input: root = []
Output: []
Input: root = [1]
Output: [1]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Left -> Right -> Node
class _3_PostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode right, left;
        TreeNode(int data) {
            this.val = data;
            right = null;
            left = null;
        }
    }

    // 1. Using Recursion
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(N) --> Space is needed for the recursion stack.

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, ArrayList<Integer> list){
        if(node != null){
            postOrder(node.right, list);
            postOrder(node.left, list);
            list.add(node.val);
        }
    }

    // 2. Iterative Approach
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(N) -->  In the worst case, (a tree with every node having a single right child and left-subtree

    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            if(curr != null) {
                stack.push(curr); // Push the current node.
                list.add(0, curr.val); // Reverse the process of preorder
                curr = curr.right;  // Reverse the process of preorder
            }

            // Encountered a left child with a null value. Pop the root node.
            else{
                curr = stack.pop(); // Root of the subtree.
                curr = curr.left; // Reverse the process of preorder
            }
        }
        return list;
    }

    // 3. Morris Postorder Traversal of a Binary tree
    // Time Complexity: O(N) -->  We are traversing N nodes and every node is visited exactly once.
    // Space Complexity: O(1) --> We are not using recursion.

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        // Reverse the process of preorder and change left to right & right to left of preOrder
        while(curr != null){
            // If we don't have right child, simply add root and traverse on left
            if(curr.right == null){
                list.add(0, curr.val);  // don't write list.add(curr.val);
                curr = curr.left;
            }

            // If we do have right child, so we need to first make a path then only we can come back to root after finishing this subtree's inorder traversal
            else {
                TreeNode predecessor = curr.right; //mark the right child

                //go to left till we get extreme left node
                while(predecessor.left != null && predecessor.left != curr) {
                    predecessor = predecessor.left;
                }

                // if pre.left is null then link it to current to reach back
                if(predecessor.left == null){
                    predecessor.left = curr; // firstly make the thread
                    list.add(0, curr.val);  // don't write list.add(curr.val);
                    curr = curr.right;
                }
                //pre.left is current meaning the right tree has been traversed so remove the link and traverse the left subtree now
                if(predecessor.left == curr) {
                    predecessor.left = null; // firstly cut the thread
                    curr = curr.left;
                }
            }
        }
        return list;
    }
}
