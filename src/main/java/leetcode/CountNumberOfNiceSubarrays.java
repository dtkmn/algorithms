package leetcode;


/**
 *  <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">1248. Count Number of Nice Subarrays</a>
 */

public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int[] preSum = new int[50000];
        preSum[0] = 1;
        int count = 0;
        int prefix_sum = 0;
        for (int n: nums) {
            prefix_sum += n % 2;
            if (prefix_sum - k >= 0 && preSum[prefix_sum - k] > 0) {
                count += preSum[prefix_sum - k];
            }
            preSum[prefix_sum]++;
        }
        return count;
    }

}
