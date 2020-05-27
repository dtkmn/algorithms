package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 */

public class LongestIncreasingSubsequence {

    // Using DP approach
    // Time Complexity: O(N2)
    // Space Complexity: O(N)
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int[] dp = new int[nums.length];
        int max = 0;

        /*
                Sample Inputs
                10, 9, 2, 5, 3,     7,      101,        18
                 1  1  1  2  2 (1+1)2    (1+1)2     (1+1)2
                               (2+1)3    (1+1)2     (1+1)2
                               (2+1)3    (1+1)2     (1+1)2
                                         (2+1)3     (2+1)3
                                         (2+1)3     (2+1)3
                                         (3+1)4     (3+1)4
                ------------------------------------------
            MAX  1  1  1  2  2      3         4          4
         */
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
            max = Math.max(max, count);
        }

        System.out.println(Arrays.toString(dp));

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 10,9,2,5,3,7,101,18 }));
        System.out.println(lengthOfLIS(new int[] { 1,3,6,7,9,4,10,5,6 }));
    }

}
