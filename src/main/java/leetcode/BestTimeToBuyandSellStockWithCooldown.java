package leetcode;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 */
public class BestTimeToBuyandSellStockWithCooldown {

    private int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        int ans = dfs(0, 0, prices);
        return ans;
    }

    public int dfs(int day, int hold, int[] prices) {
        if (day == prices.length) return 0;
        if (dp[day][hold] != -1) return dp[day][hold];

        int skipMoney = dfs(day + 1, hold, prices);
        int todayPrice = prices[day];
        int actionMoney;
        if (hold == 1) {
            // Time to sell
            actionMoney = todayPrice + dfs(day + 2,0, prices);
        } else {
            // Time to buy
            actionMoney = -todayPrice + dfs(day + 1,1, prices);
        }
        dp[day][hold] = Math.max(skipMoney, actionMoney);
        return dp[day][hold];
    }

    public static void main(String[] args) {
    }

}
