package leetcode;


import java.util.Arrays;

/*
    https://leetcode.com/problems/coin-change/
 */
public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        return dfs(dp, coins, amount);
        return dfs_bu(coins, amount);
    }

    // 23ms
    // Using DP Top Down Approach
    // Space Complexity: O(amount) i.e. dp array
    // Time Complexity: O(amount * coins length)
    private static int dfs(int[] dp, int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        if (dp[amount] != 0) return dp[amount];

        for (int coin : coins) {
            if (coin <= amount) {
                // Recursive on each (amount - coin)
                int count = dfs(dp, coins, amount - coin);
                if (count != -1) {
                    min = Math.min(min, count + 1);
                }
            }
        }
        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }

    // 11ms
    // Using DP with Bottom Up Approach
    // Space Complexity: O(amount) i.e. dp array
    // Time Complexity: O(amount * coins length)
    private static int dfs_bu(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // count = 1 + min(dp[amount - c1],dp[amount - c2],dp[amount - c3])
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1,2,5 }, 11)); // 3
        System.out.println(coinChange(new int[] { 1,2,3 }, 6)); // 2
        System.out.println(coinChange(new int[] { 2 }, 3)); // -1
        System.out.println(coinChange(new int[] { 186,419,83,408 }, 6249)); // 20
    }



}
