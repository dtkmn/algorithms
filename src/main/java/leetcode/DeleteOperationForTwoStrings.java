package leetcode;


/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 */

public class DeleteOperationForTwoStrings {

    // Using DP approach
    // Time Complexity: O(MxN)
    // Space Complexity: O(MxN)
    public static int minDistance(String word1, String word2) {

        int aLength = word1.length();
        int bLength = word2.length();

        int[][] dp = new int[aLength + 1][bLength + 1];

        for (int i = 0; i <= aLength; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= bLength; j++) {
            dp[0][j] = j;
        }

        for (int m = 1; m <= aLength; m++) {
            for (int n = 1; n <= bLength; n++) {
                if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
                    dp[m][n] = dp[m - 1][n - 1];
                } else {
                    dp[m][n] = Math.min(dp[m-1][n], dp[m][n-1]) + 1;
                }
            }
        }

        return dp[aLength][bLength];

    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }

}
