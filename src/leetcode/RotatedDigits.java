package leetcode;


/**
 * https://leetcode.com/problems/rotated-digits/
 *
 *
 */
public class RotatedDigits {

    public static int rotatedDigits(int N) {

        int count = 0;
        for (int i = 1; i <= N; i++) {
            boolean valid = false;
            int v = i;
            while (v > 0) {
                int r = v % 10;
                if (r == 3 || r == 4 || r == 7) {
                    valid = false;
                    break;
                } else if (r == 2 || r == 5 || r == 6 || r == 9) {
                    valid = true;
                }
                v /= 10;
            }
            if (valid) count++;
        }

        return count;

    }

    public static void main(String[] args) {
        // 857
        // expected answer 247
        System.out.println(rotatedDigits(857));
    }

}
