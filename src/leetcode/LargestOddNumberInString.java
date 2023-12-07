package leetcode;


/*
    https://leetcode.com/problems/largest-odd-number-in-string/
 */
public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        if (num.isEmpty()) return "";
        int i = num.length() - 1;
        while (i >= 0) {
            if ((int) num.charAt(i) % 2 != 0) break; // Break when it's odd
            i--;
        }
        return i < 0? "": num.substring(0, i + 1);
    }

    public static void main(String[] args) {

    }
}
