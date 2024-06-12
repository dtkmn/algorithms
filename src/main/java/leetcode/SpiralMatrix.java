package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">...</a>
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int topRow = 0; // going right
        int rightCol = matrix[0].length - 1; // going down
        int downRow = matrix.length - 1; // going up
        int leftCol = 0; // going left
        List<Integer> ans = new ArrayList<>();

        int step = 0;
        while (topRow <= downRow && leftCol <= rightCol) {
            int r = step % 4;
            if (r == 0) {
                for (int col = leftCol; col <= rightCol; col++) {
                    ans.add(matrix[topRow][col]);
                }
                topRow++;
            }
            else if (r == 1) {
                for (int row = topRow; row <= downRow; row++) {
                    ans.add(matrix[row][rightCol]);
                }
                rightCol--;
            }
            else if (r == 2) {
                for (int col = rightCol; col >= leftCol; col--) {
                    ans.add(matrix[downRow][col]);
                }
                downRow--;
            }
            else if (r == 3) {
                for (int row = downRow; row >= topRow; row--) {
                    ans.add(matrix[row][leftCol]);
                }
                leftCol++;
            }
            step++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new SpiralMatrix().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        System.out.println(
            integerList.toString()
        );
    }

}
