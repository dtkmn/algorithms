package leetcode;


/**
 * <a href="https://leetcode.com/problems/minimum-deletions-to-make-string-balanced">1653. Minimum Deletions to Make String Balanced</a>
 *
 */
public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int count = 0, bCount = 0;
        for (char c : cs) {
            if (c == 'b') {
                bCount++;
            } else if (bCount > 0) {
                count++;
                bCount--;
            }
        }
        return count;
    }

}
