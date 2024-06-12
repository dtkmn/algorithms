package leetcode;

import java.util.Arrays;

/**
 *      <a href="https://leetcode.com/problems/largest-submatrix-with-rearrangements/">...</a>
 */
public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int max = 0;
        for (int row = 0; row < rowCount; row++) {
            if (row > 0) {
                for (int col = 0; col < colCount; col++) {
                    if (matrix[row][col] > 0) {
                        matrix[row][col] += matrix[row - 1][col];
                    }
                }
            }
            int [] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int i = 0; i < colCount; i++) {
                max = Math.max(max, currRow[i] * (colCount - i));
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
