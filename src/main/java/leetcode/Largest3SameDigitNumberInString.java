package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        if (num.length() < 3) return "";
        int head = 0, tail = 0;
        char[] ca = num.toCharArray();
        int count = 0;
        int max = -1;
        while (tail < num.length()) {
            if (ca[tail] == ca[head]) {
                if (++count == 3) {
                    max = Math.max(max, ca[head] - '0');
                }
                tail++;
            } else {
                head = tail;
                count = 0;
            }

        }
        return max == -1 ? "" : "" + max + max + max;
    }

    public static void main(String[] args) {
//        System.out.println(
//            new Largest3SameDigitNumberInString().largestGoodInteger("2300019")
//        );
//        System.out.println(
//            new Largest3SameDigitNumberInString().largestGoodInteger("1221000")
//        );
        System.out.println(
                new Largest3SameDigitNumberInString().largestGoodInteger("6777133339")
        );
//        System.out.println(
//                new Largest3SameDigitNumberInString().largestGoodInteger("1221000")
//        );
    }

}
