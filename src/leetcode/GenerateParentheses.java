package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">...</a>
 */
public class GenerateParentheses {

    private int n;
    public List<String> generateParenthesis(int n) {
        this.n = n * 2;
        List<String> ans = new ArrayList<>();
        dfs("(", 1, ans, 1, 0);
        return ans;
    }

    public void dfs(String val, int level, List<String> ans, int leftCount, int rightCount) {
        level++;
        String left = val + "(";
        String right = val + ")";
        if (level == n) {
            // We dont need to check the extra left and only 'right' is needed
            if (leftCount == rightCount + 1) ans.add(right);
        } else {
            dfs(left, level, ans, leftCount + 1, rightCount);
            // No point to append another right when 'right' is equal to or more than left!
            if (leftCount > rightCount)
                dfs(right, level, ans, leftCount, rightCount + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new GenerateParentheses().generateParenthesis(3)
        );
    }

}
