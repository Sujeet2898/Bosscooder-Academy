/*
Question: Minimum Cost to Move Chips to The Same Position
We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
 */

public class _18_MinimumCostToMoveChipsToTheSamePosition {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    /* The chips at even index can be shifted to any even index with cost 0 and to any odd index with cost 1.
       Similarly, The chips at odd index can be shifted to any odd index with cost 0 and to any even index with cost 1.
     */
    public int minCostToMoveChips(int[] position) {
        int evenPosTowerChips = 0;
        int oddPosTowerChips = 0;
        for (int val : position) {
            if (val % 2 == 0) {
                evenPosTowerChips++;
            } else {
                oddPosTowerChips++;
            }
        }
        return Math.min(oddPosTowerChips, evenPosTowerChips);
    }
}
