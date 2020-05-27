package leetcode;


/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 */

public class LongestCommonSubsequence {

    // Using DP approach
    // Time Complexity: O(MxN)
    // Space Complexity: O(MxN)
    public static int longestCommonSubsequence(String text1, String text2) {

        int t1length = text1.length();
        int t2length = text2.length();

        int[][] dp = new int[t1length + 1][t2length + 1];

        for (int i = 0; i <= t1length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= t2length; j++) {
            dp[0][j] = 0;
        }

        /*
                Sample inputs
                   '' a b c d e
                ''  0 0 0 0 0 0
                a   0 1 1 1 1 1
                c   0 1 1 2 2 2
                e   0 1 1 2 2 3
         */
        for (int m = 1; m <= t1length; m++) {
            for (int n = 1; n <= t2length; n++) {
                if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
                    dp[m][n] = dp[m - 1][n - 1] + 1;
                } else {
                    dp[m][n] = Math.max(dp[m - 1][n], dp[m][n - 1]);
                }
            }
        }

        return dp[t1length][t2length];

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

}
