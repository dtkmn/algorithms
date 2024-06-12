package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/">...</a>
 */

public class PerfectSquares {


    /**
     * Using same approach from coin change problem
     * @param n
     * @return
     */
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        int[] dp = new int[n + 1];
        int limit = (int) sqrt;
        List<Integer> coins = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            int coin = i * i;
            dp[coin] = 1;
            coins.add(coin);
        }
        for (int j = 2; j <= n; j++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (j >= coin) {
                    min = Math.min(min, 1 + dp[j - coin]);
                } else break;
            }
            dp[j] = min;
        }
        return dp[n];
    }


    public static void main(String[] args) {

    }



}
