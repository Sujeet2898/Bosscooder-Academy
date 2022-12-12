/*
Question: K-th bit is set or not
Given a number N and a bit number K, check if the Kth bit of N is set or not. A bit is called set if it is 1.
Note: Indexing starts with 0 from LSB (least significant bit) side in the binary representation of the number.
 */

public class _1_KthBitSetOrNot {

    // Using Left Shift Operator
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static boolean isKthBitSet1(int n, int k) {
        // let n = 110101
        // 1<<4  = 010000
        // n & (1 << 4) = 010000
        if ((n & (1 << k)) != 0) {
            return true;  // bit is set
        }
        else{
            return false;  // bit is off
        }
    }

    // Using Right Shift Operator
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static boolean isKthBitSet2(int n, int k) {
        // let n = 110101
        // n>>4  = 000011
        //    1  = 000001
        //(n >> k) & 1 = 000001
        if (((n >> k) & 1) != 0) {
            return true;  // bit is set
        }
        else{
            return false;  // bit is off
        }
    }

    public static void main(String[] args) {
        int n = 53, k = 4;
        System.out.println(isKthBitSet1(n, k));  // true
        System.out.println(isKthBitSet2(n, k));  // true
    }
}
