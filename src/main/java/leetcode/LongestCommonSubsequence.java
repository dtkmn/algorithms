package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">...</a>
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


    private int[][] dp;
    private String text1;
    private String text2;
    public int longestCommonSubsequence_recursive(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dp2(0, 0);
    }

    private int dp2(int p1, int p2) {
        if (p1 >= text1.length() || p2 >= text2.length()) {
            return 0;
        }
        if (dp[p1][p2] != -1) return dp[p1][p2];

        // Option 1
        int option1 = dp2(p1 + 1, p2);
        // Option 2
        char c1 = text1.charAt(p1);
        int c2 = text2.indexOf(c1, p2);
        int option2 = 0;
        if (c2 != -1) {
            option2 = 1 + dp2(p1 + 1, c2 + 1);
            System.out.println(p1 + " : " + p2);
        }
        dp[p1][p2] = Math.max(option1, option2);
        return dp[p1][p2];
    }


    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
//        System.out.println(
//            new LongestCommonSubsequence()
//                .longestCommonSubsequence_recursive("abcde", "ace")
//        );
        System.out.println(
            new LongestCommonSubsequence()
                .longestCommonSubsequence_recursive("ezupkr", "ubmrapg")
        );
    }

}
