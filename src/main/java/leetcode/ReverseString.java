package leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">...</a>
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int fr = 0, en = s.length - 1;
        while (fr < en) {
            char c = s[fr];
            s[fr++] = s[en];
            s[en--] = c;
        }
    }

}
