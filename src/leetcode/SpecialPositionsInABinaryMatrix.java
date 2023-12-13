package leetcode;


/**
 * <a href="https://leetcode.com/problems/special-positions-in-a-binary-matrix/">...</a>
 *
 */

public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int num = 0;
        for (int m = 0; m < mat.length; m++) {
            for (int n = 0; n < mat[0].length; n++) {
                if (mat[m][n] == 1 &&
                        rowCount[m] == 1 && colCount[n] == 1 &&
                        rowCount[m] == colCount[n]) {
                    num++;
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
    }

}
