package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/description/">...</a>
 */

public class MinimumCostForTickets {


    public int mincostTickets(int[] days, int[] costs) {
        // Get the last day value
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        int dayIndex = 0;
        for (int i = 1; i <= lastDay; i++) {
            // When no travelling on specific day
            // Cost should be the same as previous day
            if (i < days[dayIndex]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int min = Integer.MAX_VALUE;
            if (i <= 1) min = Math.min(min, costs[0]);
            if (i <= 7) min = Math.min(min, costs[1]);
            if (i <= 30) min = Math.min(min, costs[2]);
            if (i >= 1) {
                min = Math.min(min, costs[0] + dp[i - 1]);
            }
            if (i >= 7) {
                min = Math.min(min, costs[1] + dp[i - 7]);
            }
            if (i >= 30) {
                min = Math.min(min, costs[2] + dp[i - 30]);
            }
            dp[i] = min;

            if (++dayIndex == days.length) break;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[lastDay];
    }

    public static void main(String[] args) {
        MinimumCostForTickets cost = new MinimumCostForTickets();
        int mincosted = cost.mincostTickets(
                new int[]{ 1, 4, 6, 7, 8, 20 },
                new int[]{ 2, 7, 15 }
        );
        System.out.println(mincosted);
    }

}
