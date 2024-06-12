package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/delete-and-earn/">...</a>
 *
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            countMap.put(num, num + countMap.getOrDefault(num, 0));
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = countMap.getOrDefault(1, 0);
        for (int k = 2; k <= max; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + countMap.getOrDefault(k, 0));
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(
            new DeleteAndEarn().deleteAndEarn(new int[] {3,4,2})
        );
        System.out.println(
            new DeleteAndEarn().deleteAndEarn(new int[] {2,2,3,3,3,4})
        );
    }

}
