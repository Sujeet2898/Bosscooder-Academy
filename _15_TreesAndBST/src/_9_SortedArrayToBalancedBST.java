/*
Question: Sorted Array to Balanced BST
Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.

Input: arr[] = {1, 2, 3}
Output: A Balanced BST
      2
    /  \
  1     3
Explanation: all elements less than 2 are on the left side of 2 , and all the elements greater than 2 are on the right side

Input: arr[] = {1, 2, 3, 4}
Output: A Balanced BST
          3
        /  \
      2     4
   /
1


 */

public class _9_SortedArrayToBalancedBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Time complexity: O(N), where N is the number of elements in the input array. This is because the function visits each element of the array once and performs a constant amount of work for each element.
    // Space complexity: O(N), where N is the number of elements in the input array. This is because the function creates a new TreeNode for each element of the array and each node takes up a constant amount of space.
    public static TreeNode sortedArrayToBST(int[] nums) {
        // If the input array is empty, return null
        if (nums.length == 0) {
            return null;
        }
        // Call the helper function with the input array, the left index, and the right index
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        // If the left index is greater than the right index, return null
        if (left > right) {
            return null;
        }
        // Calculate the middle index as the average of the left and right indices
        int mid = (left + right) / 2;
        // Create a new TreeNode with the value of the middle element
        TreeNode root = new TreeNode(nums[mid]);
        // Recursively construct the left subtree with the elements to the left of the middle element
        root.left = sortedArrayToBST(nums, left, mid - 1);
        // Recursively construct the right subtree with the elements to the right of the middle element
        root.right = sortedArrayToBST(nums, mid + 1, right);
        // Return the root node of the constructed Balanced Binary Search Tree
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        TreeNode root = sortedArrayToBST(nums);
        printInorder(root);  // 1 2 3 4
    }

    private static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
