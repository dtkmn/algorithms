package leetcode;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome-iii/">...</a>
 */
public class ValidPalindromeIII {
    /**
     *   Example 1: s = ["abcdeca], k = 2
     *
     *                       a,a
     *                        |
     * 2                    ab,ac
     *               /                 \
     * 1          abc,ae             ac,ace
     *          /      \           /        \
     * 0  abcd,ad    abd,aed    acd, acd    ad, aced
     *                           Answer!
     * @param s
     * @param k
     * @return
     */
    public boolean isValidPalindrome(String s, int k) {
        this.s = s;
        this.dp = new int[s.length()][s.length()];
        return dfs(0, s.length() - 1, k);
    }

    private String s;
    private int[][] dp;

    private boolean dfs(int l, int r, int k) {
//        System.out.println(l + ": " + r + ": " + k);
        if (k < 0) return false;
        if (l > r) {
            return k >= 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r] == 1;
        }
        if (s.charAt(l) == s.charAt(r)) {
            return dfs(l+1, r-1, k);
        } else {
            if (r - l + 1 <= k) {
                dp[l][r] = 1;
                return true;
            } else {
                boolean leftCheck = dfs(l + 1, r, k - 1);
                boolean rightCheck = dfs(l, r - 1, k - 1);
                boolean check = leftCheck || rightCheck;
                dp[l][r] = check ? 1: -1;
                return check;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(
//            new ValidPalindromeIII().isValidPalindrome("abcdeca", 2)
//        );
//        System.out.println(
//            new ValidPalindromeIII().isValidPalindrome("abbababa", 1)
//        );
//        System.out.println(
//            new ValidPalindromeIII().isValidPalindrome("bbbbabbb", 2)
//        );
//        System.out.println(
//            new ValidPalindromeIII().isValidPalindrome("bacabaaa", 2)
//        );
//        System.out.println(
//            new ValidPalindromeIII().isValidPalindrome("cacababac", 3)
//        );
        System.out.println(
            new ValidPalindromeIII().isValidPalindrome("dbabdadcbbcbacaabbbaaabdbdbcdacdcbadbacacaccdcdbabcabcbcbbcadbbbdadacdbaadaadcbcddbabddbbcacbccbddbcccbaadccddccacacadcbccbbccbdbadccbcbdbcaacbdadbdbbbdccabdbcbadacabbaadabddacaacccbccddcbddcddbddcbabbaccbdcbabbdcdacaddcdabdbbdaaccabdabbbcbbbaccdacccccdbcbaaddddbdabbbddbcbdaddddcabadbccbbaccbdbccacacbbdbdbcbccdddbabdbbadbdcdcbaabcaabdcacdcbb", 216)
        );

        System.out.println(
            new ValidPalindromeIII().isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216)
        );

    }

}
