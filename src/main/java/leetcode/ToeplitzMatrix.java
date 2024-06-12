package leetcode;


/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        // row size
        for (int i = 0; i < matrix.length; i++) {
            int m = i, n = 0;
            while (m < matrix.length && n < matrix[0].length) {
                if (matrix[i][0] != matrix[m++][n++]) return false;
            }
        }
        // column size
        for (int j = 1; j < matrix[0].length; j++) {
            int m = 0, n = j;
            while (m < matrix.length && n < matrix[0].length) {
                if (matrix[0][j] != matrix[m++][n++]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//            {1,2,3,4},
//            {5,1,2,3},
//            {9,5,1,2}
//        };
        int[][] matrix = new int[][] {
            {11,74,0,93},
            {40,11,74,7}
        };
        System.out.println(
            isToeplitzMatrix(matrix)
        );
    }

}
