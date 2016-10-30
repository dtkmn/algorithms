package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DpCoinChange {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] coins = new int[m];
        StringTokenizer row = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            coins[i] = Integer.parseInt(row.nextToken());
        }
        Arrays.sort(coins);
        int[][] dp = new int[251][51];
        for(int i=0; i<dp.length; i++)
            for(int j=0; j<dp[j].length; j++)
                dp[i][j] = -1;
        System.out.println(ways(money, coins, dp));

    }

    static int ways(int money, int[] coins, int[][] dp) {
        if(money < 0) return 0;
        if(money == 0) return 1;
        if(coins.length == 0 && money >= 1) return 0;
        if(dp[money][coins.length] != -1) return dp[money][coins.length];
        // This formula is the most important!! haha!!
        int wayss = ways(money-coins[coins.length-1], coins, dp)
                + ways(money, Arrays.copyOf(coins, coins.length-1), dp);
        dp[money][coins.length] = wayss;
        return wayss;
    }

}
