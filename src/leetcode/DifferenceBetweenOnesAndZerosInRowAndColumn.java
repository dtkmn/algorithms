package leetcode;


/**
 * <a href="https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/">...</a>
 *
 */

public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    public int[][] onesMinusZeros(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int[] onesRow = new int[rl];
        int[] onesCol = new int[cl];
        int[][] matrix = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                matrix[i][j] = onesRow[i] + onesCol[j]
                    - (rl - onesRow[i]) - (cl - onesCol[j]);
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
    }

}
