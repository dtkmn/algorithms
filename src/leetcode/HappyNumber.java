package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 *
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        // slow process only progress one
        int slow = sum(n);
        // fast process will do twice each step
        int fast = sum(sum(n));

        while (slow != fast) {
            fast = sum(sum(fast));
            slow = sum(slow);
        }
        return fast == 1;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum += r*r;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
            isHappy(19)
        );
    }

}
