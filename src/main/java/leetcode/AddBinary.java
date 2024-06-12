package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/add-binary/">...</a>
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        long sum = Long.parseLong(a, 2) + Long.parseLong(b, 2);
        return Long.toBinaryString(sum);
    }

    public static void main(String[] args) {

    }

}
