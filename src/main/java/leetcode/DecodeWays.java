package leetcode;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">...</a>
 *
 */
public class DecodeWays {
    private String s;
    private int[][] dp;
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int len = s.length();
        if (len < 2) return len;
        this.s = s;
        this.dp = new int[len][27];
        return dfs(1, String.valueOf(s.charAt(0)));
    }
    private int dfs(int pos, String last) {
        if (pos == s.length()) {
            return 1;
        }

        if (dp[pos][Integer.parseInt(last)] != 0)
            return dp[pos][Integer.parseInt(last)];

        int count = 0;
        char c = s.charAt(pos);
        // This step always executing
        if (c != '0') {
            count += dfs(pos + 1, c+"");
        }
        // This depends
        String newLast = last+c;
        int comb = Integer.parseInt(newLast);
        if (comb > 0 && comb <= 26) {
            count += dfs(pos + 1, newLast);
        }
        dp[pos][Integer.parseInt(last)] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
            new DecodeWays().numDecodings("11106")
        );
        System.out.println(
                new DecodeWays().numDecodings("06")
        );
        // 111111111111111111111111111111111111111111111
        System.out.println(
            new DecodeWays().numDecodings("111111111111111111111111111111111111111111111")
        );
    }

}
