package leetcode;


/**
 * https://leetcode.com/problems/confusing-number/
 *
 */
public class ConfusingNumber {

    public static boolean confusingNumber(int N) {
        if (N == 0 || N == 1) return false;
        boolean valid = false;
        char[] output = new char[String.valueOf(N).length()];
        int pos = 0;
        int n = N;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 2 || digit == 3 || digit == 4 ||
                digit == 5 || digit == 7) {
                return false;
            }

            if (digit == 6) output[pos++] = '9';
            else if (digit == 9) output[pos++] = '6';
            else if (digit == 0) output[pos++] = '0';
            else if (digit == 1) output[pos++] = '1';
            else if (digit == 8) output[pos++] = '8';

            n /= 10;
        }

        if (N != Integer.parseInt(String.valueOf(output))) {
            valid = true;
        }

        return valid;
    }

    public static void main(String[] args) {
//        System.out.println(confusingNumber(6));
//        System.out.println(confusingNumber(89));
//        System.out.println(confusingNumber(11));
//        System.out.println(confusingNumber(916));
//        System.out.println(confusingNumber(25));
        System.out.println(confusingNumber(0));
    }

}
