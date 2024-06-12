package leetcode;


/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexInaMountainArray {

    // Iteration Implementation
    public static int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,4,5,1};
        System.out.println("Result: " + peakIndexInMountainArray(input));
    }

}
