package leetcode;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 */

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1],
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }


    public static void main(String[] args) {
    }

}
