package leetcode;


/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    // Initial implementation
    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String a = Integer.toString(x);
        int len = a.length();
        int front = 0, last = len - 1;
        while (front < last) {
            if (a.charAt(front++) != a.charAt(last--)) return false;
        }
        return true;
    }

    // Implementation without using String
    private static boolean isPalindrome_fast(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int rn = 0;
        while(x > rn) {
            int m = x % 10;
            rn = rn * 10 + m;
            x /= 10;
        }

        return x == rn || x == rn / 10;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + isPalindrome_fast(10));
    }

}
