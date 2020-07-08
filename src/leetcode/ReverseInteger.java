package leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 *
 */
public class ReverseInteger {

    // 2ms
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int g = x % 10;
            int n = res * 10 + g;
            if ((n / 10) != res) {
                return 0;
            }
            res = n;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + reverse(120));
        System.out.println("Result: " + reverse(1534236469));
        System.out.println(1%10);
    }

}
