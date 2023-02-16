import java.util.ArrayList;
import java.util.List;

/*
Question: Left View Of BinaryTree
Given a binary tree, the left view of a binary tree is the set of all those nodes visible from the left side of the binary tree. In other words it is the set of first node of every level.
    1
   / \
  2   3
 / \   \
4   5   6
The left side view of this tree would be [1, 2, 4]. We can call the method like this:
 */

public class _15_LeftViewOfBinaryTree {

    // Time complexity: O(n), where n is the number of nodes in the binary tree. This is because we visit each node in the tree exactly once.
    // Space complexity: O(h), where h is the height of the binary tree. This is because the maximum number of recursive calls on the call stack at any given time is equal to the height of the tree. In the worst case, when the tree is skewed, the height of the tree can be n, so the space complexity could be O(n). However, in a balanced tree, the height is usually O(log n), so the space complexity is also O(log n).

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();  // create a new list to store the left side view of the tree
        leftView(root, result, 0);  // call the recursive helper function to compute the left side view
        return result;  // return the left side view list
    }

    public static void leftView(TreeNode curr, List<Integer> result, int level) {
        if (curr == null) {
            return;  // base case: if the current node is null, return without doing anything
        }
        if (level == result.size()) {
            result.add(curr.val);  // if the level is equal to the size of the result list, add the current node value to the result list
        }
        leftView(curr.left, result, level + 1);  // recursive call on the left child with the updated level
        leftView(curr.right, result, level + 1);  // recursive call on the right child with the updated level
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // Get the left side view of the binary tree
        List<Integer> result = leftSideView(root);

        // Print the result
        System.out.println(result); // Output: [1, 2, 4]
    }
}
