package leetcode;


/**
 * https://leetcode.com/problems/is-subsequence/
 *
 */

public class IsSubsequence {

    // Using 2 pointers approach
    // 0ms
    // Time Complexity: O(Length of t)
    // Space Complexity:
    //      Using charArray O(length of s + length of t)
    //      Using String.charAt() O(1) but slower
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int spos = 0;
        for (int i = 0; i < ta.length; i++) {
            if (ta[i] == sa[spos]) {
                if (spos == sa.length - 1) return true;
                spos++;
            }
        }
        return false;
    }

    // Using DP
    // 7ms
    // Time Complexity: O(SxT)
    // Space Complexity: O(SxT)
    public static boolean isSubsequenceDp(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= t.length(); j++) {
            dp[0][j] = j;
        }

        for (int m = 1; m <= s.length(); m++) {
            for (int n = 1; n <= t.length(); n++) {
                if (s.charAt(m - 1) == t.charAt(n - 1)) {
                    dp[m][n] = dp[m-1][n-1];
                } else {
                    dp[m][n] = Math.min(dp[m - 1][n - 1], Math.min(dp[m - 1][n], dp[m][n - 1])) + 1;
                }
            }
        }

        return dp[s.length()][t.length()] == (t.length() - s.length());
    }


    public static void main(String[] args) {
        System.out.println(isSubsequenceDp("ace", "abcde"));
    }

}
