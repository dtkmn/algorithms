package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/string-transformation/">...</a>
 *
 */
public class StringTransformation {

    private List<String> ans;
    private long k;
    private String target;
    public int numberOfWays(String s, String t, long k) {
        this.ans = new ArrayList<>();
        this.target = t;
        this.k = k;
        return ans.size();
    }

    private void backtrack(String current, long currentK) {
        if (currentK == k) {
            if (current.equals(target)) {
                ans.add(current);
            }
            return;
        }
        for (int i = 1; i < current.length() - 1; i++) {

        }
    }

    public static void main(String[] args) {

    }

}
