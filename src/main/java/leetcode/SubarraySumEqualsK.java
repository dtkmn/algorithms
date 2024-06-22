package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/subarray-sum-equals-k/">560. Subarray Sum Equals K</a>
 */

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0, 1);
        int ans = 0;
        int preSum = 0;
        for (int n: nums) {
            preSum += n;
            if (preSumCount.containsKey(preSum - k)) {
                ans += preSumCount.get(preSum - k);
            }
            preSumCount.put(preSum, 1 + preSumCount.getOrDefault(preSum, 0));
        }
        return ans;
    }

}
