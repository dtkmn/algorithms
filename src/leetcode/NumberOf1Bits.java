package leetcode;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int d = 0;
        while (n != 0) {
            d++;
            n = n & (n - 1);
        }
        return d;
        // return Integer.bitCount(n);
    }

    public static void main(String[] args) {

    }

}
