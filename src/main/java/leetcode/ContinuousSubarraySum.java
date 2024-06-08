package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/continuous-subarray-sum/">523. Continuous Subarray Sum</a>
 */

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (prefixSum.containsKey(mod)) {
                // Ensure the subarray length is at least 2
                // Formula: prefix_sum[j] % k == prefix_sum[i] % k implies
                // (prefix_sum[j] - prefix_sum[i]) % k == 0
                // i.e., the subarray sum from index i+1 to j is a multiple of k
                if (i - prefixSum.get(mod) > 1) {
                    return true;
                }
            } else {
                prefixSum.put(mod, i);
            }
        }
        return false;
    }

}
