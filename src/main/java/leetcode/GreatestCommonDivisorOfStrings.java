package leetcode;


import java.util.List;

/**
 * <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">...</a>
 */
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public static void main(String[] args) {

    }

}
