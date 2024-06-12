package leetcode;

/**
 * <a href="https://leetcode.com/problems/string-compression-ii/">...</a>
 *
 */
public class StringCompressionII {

    private int[][] dp;
    private String s;
    private int ans;
    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        this.ans = s.length();
        dp = new int[s.length()+1][k];
        dfs(0, k, new StringBuilder());
        return ans;
    }

    private String compress(String s) {
        char prev = s.charAt(0);
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == prev) {
                count++;
            } else {
                sb.append(prev);
                if (count > 1) sb.append(count);
                count = 1;
            }
            prev = current;
        }
        sb.append(prev);
        if (count > 1) sb.append(count);
        return sb.toString();
    }

    private void dfs(int pos, int left, StringBuilder sb) {

        if (pos == s.length()) {
            if (left > 0) return;
        }

        if (pos == s.length() && left == 0) {
//            System.out.println(sb.toString());
//            System.out.println(compress(sb.toString()));
            if (sb.isEmpty()) {
                ans = 0;
            } else {
                ans = Math.min(ans, compress(sb.toString()).length());
            }
            return;
        }

//        if (dp[pos][left] != 0) {
//            return dp[pos][left];
//        }

        char c = s.charAt(pos);

        // remaining character loop through
        // s.length() - pos + 1
        dfs(pos + 1, left, new StringBuilder(sb).append(c));

        if (left > 0) {
            dfs(pos + 1, left - 1, new StringBuilder(sb));
        }

    }

    public static void main(String[] args) {
//        System.out.println(
//            new StringCompressionII().getLengthOfOptimalCompression("aaabcccd", 2)
//        );
//        System.out.println(
//                new StringCompressionII().getLengthOfOptimalCompression("aaaaaaaaaaaa", 0)
//        );
        System.out.println(
                new StringCompressionII().getLengthOfOptimalCompression("abcdefghijklmnopqrstuvwxyz", 16)
        );
    }
}
