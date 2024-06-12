package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfaSortedArray {

    public static int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static int[] sortedSquares_with2pointers(int[] A) {

        int n = -1, p = -1;
        for(int i = 0; i < A.length; i++) {
            if (A[i] < 0 && n == -1) n = i;
            if (A[i] >= 0 && p == -1) p = i;
            A[i] = A[i] * A[i];
        }

        // no negative values involved
        if (n == -1) return A;

        // no positive values involved !! just reverse current array will do!
        if (p == -1) {
            int[] ans = new int[A.length];
            for (int i = 0, j = A.length-1; i < A.length && j >= 0 ; i++, j--) {
                ans[i] = A[j];
            }
            return ans;
        }

        // otherwise using 2 pointers to merge 2 parts
        int[] ans = new int[A.length];
        int m = p - 1;
        for(int x = 0; x < ans.length; x++) {
            if (m < 0) {
                ans[x] = A[p++];
            } else if (p >= A.length) {
                ans[x] = A[m--];
            } else if (A[p] < A[m]) {
                ans[x] = A[p++];
            } else ans[x] = A[m--];
        }

        return ans;

    }

    public static void main(String[] args) {
//        int[] input = new int[]{-4,-1,0,3,10};
        int[] input = new int[]{-7,-3,2,3,11};
        System.out.println("Result: " + Arrays.toString(sortedSquares_with2pointers(input)));
    }

}
