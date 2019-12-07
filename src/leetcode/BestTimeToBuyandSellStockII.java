package leetcode;


/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 */
public class BestTimeToBuyandSellStockII {

    // Valley / Peak Approach
    public static int maxProfit(int[] prices) {
        boolean hold = false;
        int pre = -1, profit = 0, buy = 0;
        for (int i = 0; i < prices.length; i++) {
            if (pre == -1) pre = prices[i];
            else {
                int v = prices[i];
                // always compare with ytd value and action on that
                // 1) when today going into 'valley' and holding, should sell
                if (v < pre && hold) {
                    profit += (pre - buy);
                    buy = 0;
                    hold = false;
                // 2) when today is higher, should buy on ytd value ;P
                } else if (v > pre && !hold) {
                    buy = pre;
                    hold = true;
                }
                pre = prices[i];
            }
        }

        if (hold) {
            profit += (pre - buy);
        }

        return profit;
    }

    // Simple One Pass Approach
    public static int maxProfit_simpleonpass(int[] prices) {
        int pre = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) pre = prices[i];
            else {
                if (prices[i] > pre) profit += (prices[i] - pre);
            }
            pre = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(
            maxProfit(new int[]{7,1,5,3,6,4})
        );

        System.out.println(
            maxProfit_simpleonpass(new int[]{7,1,5,3,6,4})
        );

//        System.out.println(
//            maxProfit(new int[]{1,2,3,4,5})
//        );
//
//        System.out.println(
//            maxProfit(new int[]{7,6,4,3,1})
//        );
//
//        System.out.println(
//            maxProfit(new int[]{1,2})
//        );
//
//        System.out.println(
//            maxProfit(new int[]{2,1,2,0,1})
//        );
    }

}
