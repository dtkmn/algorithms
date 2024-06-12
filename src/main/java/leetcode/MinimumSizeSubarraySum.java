package leetcode;


/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">...</a>
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int head = 0, tail = 0;
        int sum = nums[head];
        int ans = Integer.MAX_VALUE;
        while (tail < len) {
            if (sum >= target) {
                ans = Math.min(ans, tail - head + 1);
                sum -= nums[head++];
            }
            else {
                if (tail == len - 1) break;
                sum += nums[++tail];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(
            new MinimumSizeSubarraySum().minSubArrayLen(7, new int[] {2,3,1,2,4,3})
        );
    }

}
