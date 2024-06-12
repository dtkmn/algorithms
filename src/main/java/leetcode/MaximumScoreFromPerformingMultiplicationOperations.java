package leetcode;

/**
 * <a href="https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/">...</a>
 *
 */
public class MaximumScoreFromPerformingMultiplicationOperations {
    //  Bruce Force Approach
    public int maximumScore_BF(int[] nums, int[] multipliers) {
        int left = 0;
        int right = nums.length - 1;
        int[] dp = new int[multipliers.length];
        int score = 0;
        for (int i = 0; i < multipliers.length; i++) {
            if (nums[left] * multipliers[i] >= nums[right] * multipliers[i]) {
                score += nums[left] * multipliers[i];
                left++;
            } else {
                score += nums[right] * multipliers[i];
                right--;
            }
        }
        return score;
    }

    private int[][] dp;
    private int[] multipliers;
    private int[] nums;
    private int ops;
    public int maximumScore(int[] nums, int[] multipliers) {
        this.ops = multipliers.length;
        this.dp = new int[this.ops][this.ops];
        this.multipliers = multipliers;
        this.nums = nums;
        return dp(0,0);
    }
    private int dp(int count, int left) {
        if (count == ops) {
            return 0;
        }
        int multi = multipliers[count];
        int right = (nums.length - 1) - (count - left);
        if (dp[count][left] == 0) {
            dp[count][left] = Math.max(
                multi * nums[left] + dp(count + 1, left + 1),
                multi * nums[right] + dp(count + 1, left));
        }
        return dp[count][left];
    }

    public static void main(String[] args) {
        System.out.println(
            new MaximumScoreFromPerformingMultiplicationOperations().maximumScore(
              new int[] {1,2}, new int[] {2,1}
            )
        );
    }

}
