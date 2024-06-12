package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">...</a>
 *
 */
public class BestTimeToBuyandSellStockIV {

    private int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][k + 1][2];
        for (int i = 0; i <dp.length; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
//        Arrays.fill(dp, Integer.MIN_VALUE);
        int ans = dfs(0, 0, k, prices);
        return ans;
    }

    public int dfs(int day, int hold, int k, int[] prices) {
        if (day == prices.length || k == 0) return 0;
//        if (day == prices.length - 1 && hold == 0) return 0;

        if (dp[day][k][hold] != -1) return dp[day][k][hold];

        int skipMoney = dfs(day + 1, hold, k, prices);
        int todayPrice = prices[day];
        int actionMoney;
        if (hold == 1) {
            // Time to sell
            actionMoney = todayPrice + dfs(day + 1,0, k - 1, prices);
        } else {
            // Time to buy
            actionMoney = -todayPrice + dfs(day + 1,1, k, prices);
            System.out.println("Buying... on day: " + day + ", price:  " + todayPrice);
            System.out.println(actionMoney);
        }
        dp[day][k][hold] = Math.max(skipMoney, actionMoney);
        return dp[day][k][hold];
    }

    public static void main(String[] args) {
//        int maxProfit = new BestTimeToBuyandSellStockIV().maxProfit(
//                2,
//                new int[]{2, 4, 1}
//        );
//        System.out.println(maxProfit);
//
//        int maxProfit2 = new BestTimeToBuyandSellStockIV().maxProfit(
//                2,
//                new int[]{3,2,6,5,0,3}
//        );
//        System.out.println(maxProfit2);

        int maxProfit2 = new BestTimeToBuyandSellStockIV().maxProfit(
                2,
                new int[]{3,3,5,0,0,3,1,4}
        );
        System.out.println(maxProfit2);
    }

}
