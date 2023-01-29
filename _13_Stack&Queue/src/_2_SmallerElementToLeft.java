import java.util.Scanner;
import java.util.Stack;

public class _2_SmallerElementToLeft {

    // Time Complexity: O(N) --> In the worst case, we will be pushing and popping all the elements into the stack only once. Thus, complexity would be O(N).
    // Space Complexity: O(N) --> In the worst case, all the elements can be in the stack.

    public static int[] smallerElementToLeft(int[] nums) {
        int n = nums.length;
        int sel[] = new int[n];

        // Stack contains the index of the element to be processed
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // 1. Remove top element of the stack if it is greater to current element of array
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                stack.pop();
            }

            // 2. Peek the top element of the stack if it is smaller than current element of array
            if (!stack.isEmpty()) {
                sel[i] = stack.peek();
            } else {
                sel[i] = -1;
            }

            // Always add the element into the stack
            stack.push(nums[i]);
        }

        return sel;
    }
/* Input:   4 5 2 10 8
   Output: -1 4 -1 2 2
   */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int output[] = smallerElementToLeft(input);

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
