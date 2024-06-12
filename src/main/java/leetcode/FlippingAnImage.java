package leetcode;

/**
 * https://leetcode.com/problems/flipping-an-image/
 *
 */
public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {

        for (int m = 0; m < A.length; m++) {
            int[] row = A[m];
            int lo = 0, hi = row.length - 1;
            while (lo <= hi) {
                if (lo == hi) {
                    row[lo] = 1 - row[lo];
                } else {
                    int temp = row[lo];
                    row[lo] = 1 - row[hi];
                    row[hi] = 1 - temp;
                }
                lo++; hi--;
            }
        }

        return A;

    }

    public static void main(String[] args) {

    }

}
