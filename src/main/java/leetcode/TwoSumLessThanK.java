package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-less-than-k/
 *
 */
public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] A, int K) {

        if (A.length < 2) return -1;

        // Sorting the array first
        // Time Complexity: O(NlogN)
        Arrays.sort(A);

        // Using 2 pointers approach
        // Time Complexity: O(N)
        int lo = 0, hi = A.length - 1, global = -1;
        while (lo < hi) {

            // Get the sum on current pair
            int sum = A[lo] + A[hi];

            // if it is the same or larger than K, we need to reduce current hi
            if (sum >= K) hi--;

            // Comparing current sum with global
            else {

                // Current sum must be lower K, we can do comparison and replace if need
                global = Math.max(global, sum);

                // the sum may be too small so we can try to move lo forward
                lo++;

            }

        }

        return global;

    }

    public static void main(String[] args) {

        int[] input = new int[] { 254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944 };
        int K = 200;

        System.out.println(twoSumLessThanK(input, K));


    }

}
