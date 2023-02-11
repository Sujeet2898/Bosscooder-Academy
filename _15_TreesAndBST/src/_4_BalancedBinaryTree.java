/*
Question: Balanced Binary Tree
Given a binary tree, determine if it is height-balanced

Input: root = [3,9,20,null,null,15,7]
Output: true

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Input: root = []
Output: true
 */

public class _4_BalancedBinaryTree {

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

    // Time complexity: O(N^2), where N is the number of nodes in the tree. This is because for each node, both the height of its left and right subtree are calculated using the height method, which has a time complexity of O(N) in the worst case. As a result, for a skewed binary tree, the total number of calls to the height method will be N + (N-1) + (N-2) + ... + 1, which is equal to N(N+1)/2. Hence, the time complexity of the isBalanced1 function is O(N^2) in the worst case.
    // Space complexity: The space complexity of the isBalanced1 function is O(H), where H is the height of the tree. This is because the method uses a recursive approach, and for each recursive call, a new function call is added to the call stack. The maximum number of function calls in the call stack is equal to the height of the tree, so the space complexity is proportional to the height of the tree.
    // Note that, in the worst case, the height of the tree could be equal to the number of nodes, which means the space complexity could be O(N). But in the average case, the height of a balanced binary tree is logarithmic in the number of nodes, so the space complexity is usually much smaller than the time complexity.
    public boolean isBalanced1(TreeNode root) {
        // if the tree is empty, it is considered balanced
        if(root == null) return true;

        // get the height of the left subtree
        int lh = height(root.left);
        // get the height of the right subtree
        int rh = height(root.right);

        // if the absolute difference between the heights of the left and right subtrees is greater than 1,
        // the tree is not balanced
        if(Math.abs(lh-rh) > 1) {
            return false;
        }

        // check if the left subtree is balanced
        boolean lTree = isBalanced1(root.left);
        // check if the right subtree is balanced
        boolean rTree = isBalanced1(root.right);

        // if either the left or the right subtree is not balanced, the tree is not balanced
        return lTree != rTree ? false : (lTree == false ? false : true);
    }

    // helper function to get the height of a binary tree
    private int height(TreeNode root){
        // if the tree is empty, return 0
        if(root == null) {
            return 0;
        }

        // return 1 plus the maximum height of the left and right subtrees
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Optimized approach
    /*
As we can clearly see that the above approach is recalculating max depth repeatedly for each node.
We could avoid the recalculation by passing the depth bottom-up.
We use a sentinel value "–1" to represent that the tree is unbalanced so we could avoid unnecessary calculations.
In each step, we look at the left subtree’s depth (left), and ask: “Is the left subtree
unbalanced?”
If it is indeed unbalanced, we return –1 right away.
Otherwise, left represents the left subtree’s depth. We then repeat the same process for the right subtree’s depth (right).
We calculate the absolute difference between L and R. If the subtrees’ depth difference is less than one, we could return the height of the current node, otherwise return –1 meaning the current tree is unbalanced.
     */
    // Time complexity: O(N), where N is the number of nodes in the tree. This is because the dfsHeight method is called for each node in the tree, and the height of each subtree is calculated only once.
    // Space complexity: O(H), where H is the height of the tree. This is because the method uses a recursive approach, and for each recursive call, a new function call is added to the call stack. The maximum number of function calls in the call stack is equal to the height of the tree, so the space complexity is proportional to the height of the tree.
    public boolean isBalanced(TreeNode root) {
        // checks if the height of the tree is not equal to -1, which indicates an unbalanced tree
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root){
        // if the root is null, the height is 0
        if(root == null) {
            return 0;
        }

        // calculate the height of the left subtree
        int leftH = dfsHeight(root.left);
        // if the height of the left subtree is -1, it indicates an unbalanced tree, so return -1
        if(leftH == -1) {
            return -1;
        }

        // calculate the height of the right subtree
        int rightH = dfsHeight(root.right);
        // if the height of the right subtree is -1, it indicates an unbalanced tree, so return -1
        if(rightH == -1) {
            return -1;
        }

        // check if the absolute difference between the height of the left and right subtrees is greater than 1
        if(Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        // return the height of the tree, which is 1 plus the maximum height of the left and right subtrees
        return 1 + Math.max(leftH, rightH);
    }
}
