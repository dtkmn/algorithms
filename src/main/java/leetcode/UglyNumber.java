package leetcode;

/**
 * https://leetcode.com/problems/ugly-number/
 *
 */
public class UglyNumber {

    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        return mod(num);
    }

    private boolean mod(int num) {
        while (num % 5 == 0) num /= 5;
        while (num % 3 == 0) num /= 3;
        while (num % 2 == 0) num /= 2;
        return num == 1;
    }

    public static void main(String[] args) {

    }

}
