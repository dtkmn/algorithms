package leetcode;


/**
 * https://leetcode.com/problems/uncrossed-lines/
 *
 */

public class UncrossedLines {

    // Using DP Approach
    // Time Complexity: O(Alength x Blength)
    // Space Complexity: O(Alength x Blength)
    public static int maxUncrossedLines(int[] A, int[] B) {

        int aLength = A.length;
        int bLength = B.length;

        int[][] dp = new int[aLength + 1][bLength + 1];

        /*
                Sample inputs
                    '' 1  4  2
                ''  0  0  0  0
                 1  0  1  1  1
                 2  0  1  1  2
                 4  0  1  2  2
         */
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[aLength][bLength];
    }

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[] { 3,4 }, new int[] { 1,2 }));
        System.out.println(maxUncrossedLines(new int[] { 1,4,2 }, new int[] { 1,2,4 }));
        System.out.println(maxUncrossedLines(new int[] { 2,5,1,2,5 }, new int[] { 10,5,2,1,5,2 }));
        System.out.println(maxUncrossedLines(new int[] { 1,3,7,1,7,5 }, new int[] { 1,9,2,5,1 }));
    }

}
