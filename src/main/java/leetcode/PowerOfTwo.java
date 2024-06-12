package leetcode;


/**
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {

    // Using Bitwise operators
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    /*
        eg.
            x   = 100
            x-1 = 011
            ---------
            &   = 000
     */
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(
            isPowerOfTwo(-2147483648)
        );
        System.out.println(
            isPowerOfTwo(16)
        );
        System.out.println(
            isPowerOfTwo(218)
        );
    }

}
