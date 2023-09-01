package leetcode;


/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">...</a>
 */
public class SearchA2dMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int cLen = matrix[0].length;
        int lo = 0;
        int hi = matrix.length * matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / cLen, c = mid % cLen;
            if (matrix[r][c] == target) return true;
            if (matrix[r][c] > target) {
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(searchMatrix(matrix, 13));
    }

}
