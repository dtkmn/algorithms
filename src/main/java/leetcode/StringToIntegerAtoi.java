package leetcode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 */
public class StringToIntegerAtoi {

    // 2ms ~80+%
    // Time Complexity: O(length of input string)
    // Space Complexity: O(1)
    public int myAtoi(String str) {
        // Remove all whitespaces
        str = str.trim();
        // Return 0 when it is 0
        if (str.length() == 0) return 0;
        // Check the first character
        char first = str.charAt(0);
        int m = first == '-' ? -1 : 1;
        if (first == '-' || first == '+') str = str.substring(1);
        int len = str.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int value = c - '0';
            if (value >= 0 & value <= 9) {
                int newRes = res * 10 + value;
                // Check if it will be overflowed
                if (newRes / 10 != res) {
                    return m == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = newRes;
            } else return m * res;;
        }
        return m * res;
    }

    public static void main(String[] args) {

    }

}
