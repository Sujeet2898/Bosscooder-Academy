/*
Question: check whether a number is Prime or not?
*/
public class _7_PrimeOrNot {

    // Time Complexity: O(sqrt(n))
    // Space Complexity: O(1)
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isPrime(n));
    }
}
