package leetcode;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">...</a>
 *
 */
public class ClimbingStairs {

    public int climbStairs_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        return check(n, dp);
    }

    private int check(int n, int[] dp) {
        if (dp[n] == 0) {
            dp[n] = check(n - 1, dp) + check(n - 2, dp);
            return dp[n];
        } return dp[n];
    }

    // Using Fibonacci Number Approach
    // 0ms
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    public int climbStairs_it(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prevprev = 1;
        int prev = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = prevprev + prev;
            prevprev = prev;
            prev = ans;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
