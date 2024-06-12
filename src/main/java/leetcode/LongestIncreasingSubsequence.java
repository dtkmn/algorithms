package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">...</a>
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
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq.getLast()) {
                seq.add(nums[i]);
            } else {
                // Find the first item bigger than nums[i] using binary search
                int mi = binarySearch(seq, nums[i]);
                seq.set(mi, nums[i]);
            }
//            System.out.println(seq);
        }
        return seq.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int m = list.get(mid);
            if (m == num) return mid;
            if (m > num) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[] { 10,9,2,5,3,7,101,18 }));
//        System.out.println(lengthOfLIS(new int[] { 1,3,6,7,9,4,10,5,6 }));
//        System.out.println(lengthOfLIS(new int[] { 0,1,0,3,2,3 }));

//        System.out.println(
//            new LongestIncreasingSubsequence().lengthOfLISv2(new int[] { 10,9,2,5,3,7,101,18 })
//        );
//        System.out.println(
//            new LongestIncreasingSubsequence().lengthOfLISv2(new int[] { 0,1,0,3,2,3 })
//        );
        System.out.println(
            new LongestIncreasingSubsequence().lengthOfLIS2(new int[] { 4,10,4,3,8,9 })
        );
        System.out.println(
            new LongestIncreasingSubsequence().lengthOfLIS2(new int[] { 3,5,6,2,5,4,19,5,6,7,12 })
        );

    }

}
