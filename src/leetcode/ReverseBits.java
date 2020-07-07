package leetcode;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 */
public class ReverseBits {

    public static int reverseBits_tle(int n) {
        int res = 0;
        int i = 0, pow = 31;
        while (n != 0) {
            // res += (n % 2) << pow--;
            res += (n & 1) << pow;
            n = n >> 1;
            pow--;
        }
        return res;
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res += (n & 1) << i;
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(reverseBits(-3));
    }

}
