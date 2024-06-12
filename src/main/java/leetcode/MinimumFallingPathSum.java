package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/">...</a>
 */
public class MinimumFallingPathSum {
    private int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0) return -1; // ?
        dp = new int[matrix.length][matrix[0].length];
        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            ans = Math.min(ans, dfs(0, col, matrix));
        }
        for (int[] row: dp) {
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }

    /**
     *  Basic DFS with DP but getting TLE :D
     * @param row
     * @param col
     * @param matrix
     * @return
     */
    public int dfs(int row, int col, int[][] matrix) {
        if (col < 0 || col >= matrix[0].length) {
            return 0;
        }

        if (row == matrix.length) {
            return 0;
        }

        if (dp[row][col] != 0) return dp[row][col];

        // row + 1, col - 1
        // row + 1, col
        // row + 1, col + 1
        int min = Integer.MAX_VALUE;
        int currentValue = matrix[row][col];
        if (col - 1 >= 0) {
            int one = currentValue + dfs(row + 1, col - 1, matrix);
            min = Math.min(min, one);
        }

        int two = currentValue + dfs(row + 1, col, matrix);
        min = Math.min(min, two);

        if (col + 1 < matrix.length) {
            int three = currentValue + dfs(row + 1, col + 1, matrix);
            min = Math.min(min, three);
        }
        dp[row][col] = min;
        return dp[row][col];
    }

    /**
     * Bottom up DP and pass. Can we get it better on space?
     * @param matrix
     * @return
     */
    public int minFallingPathSum_it(int[][] matrix) {
        if (matrix.length == 0) return -1; // ?

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }
        for (int r = matrix.length - 1; r > 0; r--) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentValue = dp[r][c];
                if (c - 1 >= 0) {
                    int temp = currentValue + matrix[r - 1][c - 1];
                    dp[r - 1][c - 1] = Math.min(dp[r - 1][c - 1], temp);
                }
                if (c + 1 < matrix[r].length) {
                    int temp = currentValue + matrix[r - 1][c + 1];
                    dp[r - 1][c + 1] = Math.min(dp[r - 1][c + 1], temp);
                }
                int temp = currentValue + matrix[r - 1][c];
                dp[r - 1][c] = Math.min(dp[r - 1][c], temp);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int firstRowItem: dp[0]) {
            ans = Math.min(ans, firstRowItem);
        }
        return ans;
    }

    /**
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum_itspace(int[][] matrix) {
        if (matrix.length == 0) return -1; // ?
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];

        int[] oldDp = new int[matrix[0].length];
        int[] newDp = new int[matrix[0].length];
        Arrays.fill(newDp, Integer.MAX_VALUE);

        for (int j = 0; j < matrix[0].length; j++) {
            oldDp[j] = matrix[matrix.length - 1][j];
        }

        for (int r = matrix.length - 1; r > 0; r--) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentValue = oldDp[c];
                if (c - 1 >= 0) {
                    newDp[c - 1] = Math.min(newDp[c - 1], currentValue + matrix[r - 1][c - 1]);
                }
                if (c + 1 < matrix[r].length) {
                    int temp = currentValue + matrix[r - 1][c + 1];
                    newDp[c + 1] = Math.min(newDp[c + 1], temp);
                }
                int temp = currentValue + matrix[r - 1][c];
                newDp[c] = Math.min(newDp[c], temp);
            }
            oldDp = newDp.clone();
            if (r > 1) Arrays.fill(newDp, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int firstRowItem: newDp) {
            ans = Math.min(ans, firstRowItem);
        }
        return ans;
    }

    public static void main(String[] args) {
        int minSum = new MinimumFallingPathSum().minFallingPathSum_itspace(
            new int[][] {
                {2,1,3},
                {6,5,4},
                {7,8,9}
            }
        );
        System.out.println(minSum);
    }

}
