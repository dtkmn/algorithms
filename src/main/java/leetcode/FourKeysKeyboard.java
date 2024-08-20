package leetcode;

/**
 * <a href="https://leetcode.com/problems/4-keys-keyboard/">651. 4 Keys Keyboard</a>
 *
 */
public class FourKeysKeyboard {

    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // Option 1: Just press 'A'
            dp[i] = dp[i - 1] + 1;
            // Option 2: Consider using Ctrl-A, Ctrl-C, followed by multiple Ctrl-V
            for (int j = 3; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j - 1] * (i - j));
            }
        }
        return dp[n];
    }

}
