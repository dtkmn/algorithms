package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 */

public class MinimumASCIIDeleteSumForTwoStrings {

    // Using DP approach
    // Time Complexity: O(MxN)
    // Space Complexity: O(MxN)
    public static int minimumDeleteSum(String s1, String s2) {
        int s1length = s1.length();
        int s2length = s2.length();

        int[][] dp = new int[s1length + 1][s2length + 1];

        for (int i = 1; i <= s1length; i++) {
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }

        for (int j = 1; j <= s2length; j++) {
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }

        /*
                Sample inputs
                      ''    s    e    a
                  ''   0    s   se  sea
                   e   e   es    s   sa
                   a  ea  eas   sa    s
                   t eat eats  sat   st
         */
        for (int m = 1; m <= s1length; m++) {
            for (int n = 1; n <= s2length; n++) {
                if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                    dp[m][n] = dp[m - 1][n - 1];
                } else {
//                    dp[m][n] = dp[m - 1][n] <= dp[m][n -1] ?
//                        dp[m - 1][n] + s1.charAt(m - 1) : dp[m][n-1] + s2.charAt(n - 1);
                    // Above not working since ascii code value will confuse
                    dp[m][n] = Math.min(dp[m - 1][n] + s1.charAt(m - 1), dp[m][n-1] + s2.charAt(n - 1));
                }
            }
        }

        for (int[] row: dp)
            System.out.println(Arrays.toString(row));

        return dp[s1length][s2length];

    }

    public static void main(String[] args) {
        // 231
        System.out.println(minimumDeleteSum("sea", "eat"));
        // 403
        System.out.println(minimumDeleteSum("delete", "leet"));
        // 1178
        System.out.println(minimumDeleteSum("caabcccaccccca", "cacbaaac"));
    }

}
