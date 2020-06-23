package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // Only need to do it once!
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[len + 1];
        digits[0] = 1;

        return digits;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 9 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 4 })));
        System.out.println(Arrays.toString(plusOne(new int[] { 9, 4, 9, 9 })));

    }

}
