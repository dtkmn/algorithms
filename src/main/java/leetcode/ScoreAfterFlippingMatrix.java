package leetcode;

/**
 * <a href="https://leetcode.com/problems/score-after-flipping-matrix/">...</a>
 *
 s */

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        int ans = 0;

        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == 0) {
                // Flip own row!
                for (int c = 0; c < grid[row].length; c++) {
                    if (grid[row][c] == 1) grid[row][c] = 0;
                    else grid[row][c] = 1;
                }
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            int countZero = 0;
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][j] == 0) countZero++;
            }
            if (countZero > grid.length / 2) {
                // Flip own column!
                for (int r = 0; r < grid.length; r++) {
                    if (grid[r][j] == 0) grid[r][j] = 1;
                    else grid[r][j] = 0;
                }
            }
        }

        for (int r = 0; r < grid.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < grid[r].length; c++) {
                sb.append(grid[r][c]);
            }
            ans += Integer.parseInt(sb.toString(), 2);
        }

        return ans;
    }

}
