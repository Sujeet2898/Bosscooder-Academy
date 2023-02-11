/*
Question: Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 */

public class _5_ConvertSortedArrayToBinarySearchTree {
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

    // Time complexity: O(N), where N is the length of the input array. This is because, in the worst case, the function will traverse through N/2 elements in the array for each level of the BST, resulting in a total of N elements.
    // Space complexity: O(log N) in the average case and O(N) in the worst case, where N is the length of the input array. This is because, in the average case, the height of the BST will be log N, and the maximum size of the call stack will be log N. However, in the worst case, when the input array is sorted in either ascending or descending order, the BST will be degenerate, and the height will be N, resulting in a space complexity of O(N).
    public TreeNode sortedArrayToBST(int[] nums) {
        // If the input array is empty, return null
        if (nums.length == 0) {
            return null;
        }

        // Call the helper function to generate the BST
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        // If the low index is greater than the high index, return null
        if (low > high) {
            return null;
        }

        // Calculate the middle index
        int mid = (low + high) / 2;
        // Create a new node with the value at the middle index
        TreeNode node = new TreeNode(nums[mid]);
        // Recursively generate the left and right subtrees
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
