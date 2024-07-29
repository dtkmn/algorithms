package leetcode;


/**
 * <a href="https://leetcode.com/problems/minimum-moves-to-convert-string/">2027. Minimum Moves to Convert String</a>
 *
 */
public class MinimumMovesToConvertString {

    public int minimumMoves(String s) {
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == 'X') {
                ans++;
                i += 3;
            } else {
                i++;
            }
        }
        return ans;
    }

}
