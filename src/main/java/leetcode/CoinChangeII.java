package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/">...</a>
 */
public class CoinChangeII {


    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp = new int[amount + 1][coins.length + 1];
        return dfs(amount, coins.length - 1, coins);
    }

    private int[][] dp;
    public int dfs(int remain, int pos, int[] coins) {
        if (remain == 0) {
            return 1;
        }
        if (pos < 0 || remain < 0) {
            return 0;
        }
        if (dp[remain][pos] != 0) return dp[remain][pos];
        int count = 0;
        for (int i = pos; i >= 0; i--) {
            if (remain < coins[i]) continue;
            count += dfs(remain - coins[i], i, coins);
        }
        dp[remain][pos] = count;
        return dp[remain][pos];
    }

    public static void main(String[] args) {
        int change = new CoinChangeII().change(
                5,
                new int[]{1, 2, 5}
        );
        System.out.println(change);
    }



}
