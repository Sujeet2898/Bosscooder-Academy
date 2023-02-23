/*
Question: Path Sum
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
 */

public class _20_PathSum {

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
    /*
    Using top down recursion approach:
Create a helper function called "rootToLeafPathSum" that takes in three parameters: a binary tree node, a target sum, and a current sum.
Check if the current node is null, and if so, return false.
Check if the current node is a leaf node (i.e. has no left or right children), and if so, add the value of the node to the current sum.
If the current sum equals the target sum, return true.
Recursively call the "rootToLeafPathSum" function on the left and right children of the current node, passing in the updated current sum.
Return the result of the recursive calls.
In the "hasPathSum" function, initialize the current sum to 0 and call the "rootToLeafPathSum" function on the root node, passing in the target sum and current sum as parameters.
Return the result of the "rootToLeafPathSum" function call.
     */

    // Time complexity of the rootToLeafPathSum() method is O(N), where N is the number of nodes in the input binary tree. This is because the method visits each node in the binary tree only once, and performs a constant amount of work for each node. Specifically, it performs a constant amount of work to check if the node is a leaf, and a constant amount of work to make recursive calls on its left and right subtrees.
    // Space complexity of the rootToLeafPathSum() method is O(H), where H is the height of the binary tree. This is because the method maintains a recursive call stack that can grow as large as the height of the binary tree. Specifically, each recursive call on a subtree adds a new frame to the call stack, and the maximum number of frames that can be present on the call stack at any given time is equal to the height of the binary tree. In the worst case, where the binary tree is unbalanced and has a height of N, the space complexity can be O(N).
    // Space complexity of the hasPathSum() method is O(1), since it only stores a single integer value representing the initial sum, and does not make any recursive calls or maintain any additional data structures.
    public static boolean rootToLeafPathSum(TreeNode root, int targetSum, int sum){
        // If the root node is null, there cannot exist any path.
        if(root == null)
            return false;

        // If the root node is a leaf, check if the sum of values from root to leaf equals the target sum.
        if(root.left == null && root.right == null){
            sum = sum + root.val;
            if(sum == targetSum)
                return true;
        }

        // Check if there exists a path from the root to the left or right subtree that equals the target sum.
        return rootToLeafPathSum(root.left, targetSum, sum + root.val) || rootToLeafPathSum(root.right, targetSum, sum + root.val);
    }

    // This code defines a method to check if there exists a path from the root of a binary tree to any of its leaves, such that the sum of values of the nodes along the path is equal to a target sum.
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return rootToLeafPathSum(root, targetSum, sum);
    }
    // The code takes in a TreeNode object representing the root of the binary tree, and an integer targetSum representing the sum to be achieved along the path. The sum parameter is initialized to 0 in the hasPathSum() method, which is called to start the path sum computation. The rootToLeafPathSum() method is called recursively on the left and right subtrees of the binary tree to check for a path that equals the target sum, by adding the value of the root to the sum along the path. If a leaf node is reached, the sum is checked against the targetSum. If the sum equals the target sum, true is returned, indicating the existence of the path. If no path is found, false is returned.

    public static void main(String[] args) {

        // Create a binary tree with the following structure:
        //        5
        //       / \
        //      4   8
        //     /   / \
        //    11  13  4
        //   /  \      \
        //  7    2      1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        // Check if there exists a path from the root to a leaf that equals the target sum.
        boolean hasPathSum = hasPathSum(root, targetSum);

        if (hasPathSum) {
            System.out.println("There exists a path from the root to a leaf that equals the target sum.");
        } else {
            System.out.println("There does not exist a path from the root to a leaf that equals the target sum.");
        }

        // Output: There exists a path from the root to a leaf that equals the target sum.
    }
}
