/*
Question: Assign Mice to Holes
There are N Mice and N holes are placed in a straight line. Each hole can accommodate only 1 mouse. A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x -1. Any of these moves consumes 1 minute. Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Input : positions of mice are:
          4 -4 2
        positions of holes are:
          4 0 5
Output :  4
Assign mouse at position x = 4 to hole at
position x = 4 : Time taken is 0 minutes
Assign mouse at position x=-4 to hole at
position x = 0 : Time taken is 4 minutes
Assign mouse at position x=2 to hole at
position x = 5 : Time taken is 3 minutes
After 4 minutes all of the mice are in the holes.
Since, there is no combination possible where
the last mouse's time is less than 4,
answer = 4.

Input :  positions of mice are:
        -10, -79, -79, 67, 93, -85, -28, -94
          positions of holes are:
         -2, 9, 69, 25, -31, 23, 50, 78
Output : 102
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _3_AssignMiceToHoles {

    // Greedy approach
    // Time Complexity: Sorting the mice and holes ArrayLists takes O(n log n) time, where n is the size of the ArrayLists. Looping through each index of the mice and holes ArrayLists and computing the absolute difference between the corresponding elements takes O(n) time in the worst case, since it requires a constant amount of time to compute the absolute difference. Therefore, the overall time complexity of the method is O(n log n).
    // Space Complexity: O(n), where n is the size of the ArrayLists. The space required to store the size, max, and i variables is O(1), since they are all primitive data types. Therefore, the overall space complexity of the method is O(n).

    public static int assignHole(ArrayList<Integer> mice, ArrayList<Integer> holes){
        // If the size of the mice ArrayList does not equal the size of the holes ArrayList, return -1
        if (mice.size() != holes.size())
            return -1;

        // Sorts the mice and holes ArrayLists in ascending order
        Collections.sort(mice);
        Collections.sort(holes);

        // Initializes a variable called size to the size of the mice ArrayList
        int size = mice.size();

        // Initializes a variable called max to 0
        int max = 0;

        // Loops through each index of the mice and holes ArrayLists
        for (int i=0; i<size; i++)
            // Calculates the absolute difference between the value at the ith index of the mice and holes ArrayLists
            // If it is greater than the current value of max, update max to the new value
            if (max < Math.abs(mice.get(i)-holes.get(i)))
                max = Math.abs(mice.get(i)-holes.get(i));

        // Return the absolute value of max
        return Math.abs(max);
    }

    public static void main(String[] args) {
        ArrayList<Integer> mice = new ArrayList<>(Arrays.asList(4, -4, 2));
        ArrayList<Integer> holes = new ArrayList<>(Arrays.asList(4, 0, 5));
        int ans = assignHole(mice, holes);
        System.out.println("The minimum time required to assign all mice to their holes is: " + ans);
        // The minimum time required to assign all mice to their holes is: 4
    }
}
