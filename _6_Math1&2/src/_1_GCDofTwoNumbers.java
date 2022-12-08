public class _1_GCDofTwoNumbers {

    // Brute force approach
    // Time Complexity: O(min(a,b))
    // Space Complexity: O(1)
    public static int gcd1(int a, int b){
        int result = Math.min(a, b); //maximum possible value of gcd(a,b) is min(a,b)
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result; //return gcd of a and b
    }

    public static int gcd2(int a, int b){
        int result = Math.min(a, b); //maximum possible value of gcd(a,b) is min(a,b)
        for(int i = result; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1; //return gcd of a and b
    }

    // Optimal approach (Euclidean Algorithm for gcd)
    // Time Complexity: O(log max(a,b))
    // Space Complexity: O(1)

    public static int gcd3(int a, int b){
        // suppose a is divisor and b is remainder
        if(b == 0){
            return a;
        }
        if(a < b){
            return gcd3(b,a);
        }
        return gcd3(a % b, b); // divisor becomes a%b and remainder becomes b
    }

    public static void main (String[] args) {
        int a = 98, b = 56;
        System.out.println(gcd1(a, b));
        System.out.println(gcd2(a, b));
        System.out.println(gcd3(a, b));
        // output: 14
    }
}
