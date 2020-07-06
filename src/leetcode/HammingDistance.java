package leetcode;

/**
 * https://leetcode.com/problems/hamming-distance/
 *
 */
public class HammingDistance {

    // Using Java built-in function
    public int hammingDistance_builtin(int x, int y) {
        return Integer.bitCount(x^y);
    }

    // 1) Doing XOR to generate the diff
    // 2) Then we count 1 bit using x & (x - 1)
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int d = 0;
        while (t != 0) {
            d++;
            t = t & (t - 1);
        }
        return d;
    }

    public int hammingDistance_mod2(int x, int y) {
        int t = x ^ y;
        int d = 0;
        while (t != 0) {
            if (t % 2 == 1) d++;
            // Right shift
            t = t >> 1;
        }
        return d;
    }

    public static void main(String[] args) {

    }

}
