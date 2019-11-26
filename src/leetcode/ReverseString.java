package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int fr = 0, en = s.length - 1;
        while (fr < en) {
            char c = s[fr];
            s[fr++] = s[en];
            s[en--] = c;
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'H','a','n','n','a','h'};
        reverseString(input);
        System.out.println(
            Arrays.toString(input)
        );
    }

}
