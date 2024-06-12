package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 */
public class UniquePaths {

    // Time Complexity: O(MxN)
    // Space Complexity: O(MxN)
    /*
            Sample Input
            1  1  1
            1  2  3
            1  3  6
            1  4 10
     */
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) matrix[i][j] = 1;
                else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

}
