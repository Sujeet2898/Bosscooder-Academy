/*
Question: Binary Search Tree Iterator
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False

Constraints:
The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 106
At most 105 calls will be made to hasNext, and next.
 */

import java.util.Stack;

public class _17_BinarySearchTreeIterator {

    public class TreeNode {
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

  /*

  // 1. BruteForce Approach
    // Time complexity of the BSTIterator constructor is O(n), where n is the number of nodes in the binary search tree. This is because the inorder() method performs an inorder traversal of the tree, which visits each node once. During the traversal, the method adds each node's value to an ArrayList in O(1) time. Therefore, the time complexity of inorder() is also O(n).
    // Time complexity of the next() and hasNext() methods is O(1), as they simply access elements in the ArrayList and perform a comparison operation, respectively.
    // Space complexity of the BSTIterator object is O(n), as the constructor stores the values of each node in the binary search tree in an ArrayList. Since the ArrayList will contain all n nodes of the tree, the space complexity of the list ArrayList is O(n). The space complexity of the other variables in the class, such as i and rootnode, is O(1).

    // Create an ArrayList to store the values of the tree in sorted order
    List<Integer> list = new ArrayList<>();

    // Initialize a counter variable to keep track of the current index in the list
    int i = 0;

    // Declare a TreeNode variable to store the root of the binary search tree
    TreeNode rootnode;

    // Constructor to create a new BSTIterator object and perform inorder traversal of the tree
    public _17_BinarySearchTreeIterator(TreeNode root) {
        rootnode = root;
        inorder(rootnode);
    }

    // Returns the next smallest element in the binary search tree
    public int next() {
        return list.get(i++);
    }

    // Returns true if there are more elements in the iterator
    public boolean hasNext() {
        if(i < list.size())
            return true;
        return false;
    }

    // Performs an inorder traversal of the binary search tree and adds each element to the ArrayList
    public void inorder(TreeNode root){
        if(root == null)
            return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    */

    // 2. Optimized
/*
1. Brute force way - You can do in-order traversal and put each element into an ArrayList (additional space).
	Then use that to check hasNext() or next() element. However, that approach will use extra space of O(n).
2. This approach:
	a) Here we will use our own Stack (basically do in-order traversal Iteratively, instead of recursively).
	   Reason, being we have more control here and no need to use extra space of O(n) for ArrayList to store all elements first.
	b) We get space of O(h) only instead of O(n). [h: is height of tree]

	Time complexity:
-------------------------------
The initialization in the constructor takes O(h) time, where h is the height of the binary search tree. This is because the updateStack method is called once on the leftmost node of the tree, and it traverses down the left branch of the tree until it reaches the smallest value. Since the height of a binary search tree is O(log n) on average (where n is the number of nodes), the initialization takes O(log n) time on average.
The next method takes O(1) time, since it simply pops the next node off the stack and returns its value. If the updateStack method needs to be called, it takes O(h) time, but this occurs at most once per node, so the overall time complexity of calling next n times is O(n).
The hasNext method takes O(1) time, since it just checks whether the stack is empty.
Therefore, the overall time complexity of the iterator is O(n), where n is the number of nodes in the binary search tree.
Space complexity:
----------------------------
The space complexity of the iterator is O(h), where h is the height of the binary search tree. This is because the stack will contain at most h nodes at any given time, since it stores the leftmost nodes of the tree up to the current node. On average, the height of a binary search tree is O(log n), so the space complexity is O(log n) on average.
 */
    Stack<TreeNode> stack;   // Declare a stack of TreeNodes.
    public _17_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();    // Initialize the stack.
        TreeNode node = root;     // Set the starting node to be the root of the tree.
        updateStack(node);        // Call the updateStack method to initialize the stack with the leftmost nodes of the tree.
    }

    public int next() {
        TreeNode toRemove = stack.pop();             // Get the next node from the stack.
        updateStack(toRemove.right);                // Call the updateStack method to add the next smallest node to the stack.
        return toRemove.val;                        // Return the value of the node that was popped off the stack.
    }

    public boolean hasNext() {
        return !stack.isEmpty();                    // Check if the stack is empty.
    }

    public void updateStack(TreeNode node){
        while(node != null){
            stack.add(node);                        // Add the node to the stack.
            node = node.left;                       // Move to the next smallest node in the tree.
        }
    }
}
