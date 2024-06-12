package leetcode;


/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">...</a>
 */
public class SearchA2dMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (target > matrix[r][c]) r++;
            else if (target < matrix[r][c]) c--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }

}
