package leetcode;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 */
public class CountSquareSubmatricesWithAllOnes {

    // Time Complexity: O(MxN)
    // Space Complexity: O(1)
    public static int countSquares2(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (matrix[i][j] == 1) {
                        // Get the minimum from 3 nearby values and add to current one
                        int min = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                        matrix[i][j] = min + matrix[i][j];
                    }
                }
                count += matrix[i][j];
            }
        }
        return count;
    }

    // First Approach ;P it's slow
    public static int countSquares(int[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] != 1) continue;

                count++;
                int side = 1;

                while (true) {
                    boolean square = true;
                    if (i - side >= 0 && j - side >= 0) {
                        for (int x = i - side; x <= i; x++) {
                            if (matrix[x][j - side] != 1) {
                                square = false;
                                break;
                            }
                        }
                        for (int y = j - side; y <= j; y++) {
                            if (matrix[i - side][y] != 1) {
                                square = false;
                                break;
                            }
                        }
                    } else break;

                    if (square) {
                        count++;
                        System.out.println(i + " " + j + " " + side);
                    } else break;

                    side++;

                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 13
        System.out.println(countSquares2(new int[][] {
            { 0,1,1,1 },
//            { 1,1,0,1 },
            { 1,1,1,1 },
            { 0,1,1,1 }
        }));
    }

}
