/*
Question: Position of rightmost set bit
Given a number, find position of rightmost set bit. A bit is called set if it is 1.
Note: Indexing starts with 0 from LSB (least significant bit) side in the binary representation of the number.
 */

public class _2_PositionOfRightmostSetBit {

    // Using Right Shift Operator
    // Time Complexity: O(logn) --> Traversing through all the bits of N, where at max there are logN bits.
    // Space Complexity: O(1)
    public static int rightMostSetBit1(int n) {
        int p = 0;

        // Iterate till number > 0
        while (n > 0) {
            // Checking if last bit is set
            if ((n & 1) != 0) {
                return p;
            }

            // Increment position and right shift number
            p++;
            n = n >> 1;
        }

        return -1; // set bit not found.
    }

    public static void main(String[] args) {
        int n = 22; // 10110
        System.out.println(rightMostSetBit1(n)); // 1
    }
}
