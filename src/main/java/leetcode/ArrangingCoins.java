package leetcode;


/**
 * https://leetcode.com/problems/arranging-coins/
 */
public class ArrangingCoins {


    // Mathematics Approach
    // Switch to double with 2.0 is slower!! 3ms
    // return (int) (Math.sqrt(2.0 * n + 0.25) - 0.5);
    // For long, 1ms
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public static int arrangeCoins(int n) {
        /*
            *               r = 1, ans = 1
            * *             r = 2, ans = 1
            * * *           r = 3, ans = 2
            * * * *         r = 4, ans = 2
            * * * * *       r = 5, ans = 2
            * * * * * *     r = 6, ans = 3
        */
        // r * (r + 1) / 2 <= n
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    // Using Binary Search Approach
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public static int arrangeCoins_bs(int n) {

        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;

        // n * (n + 1) / 2 => require coins
        // 0, 1, 2, 3, 4, 5, 6, ... n
        long start = 0, end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) return (int) mid;
            if (coins > n) end = mid - 1;
            else start = mid + 1;
        }
        return (int) end;

    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
        System.out.println(arrangeCoins_bs(1804289383));
    }

}
