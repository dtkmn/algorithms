package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">...</a>
 *
 */
public class PalindromePartitioning {


    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int start, List<String> currentList) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentList);
                currentList.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> partitions = new PalindromePartitioning().partition("aab");
        for (List<String> p: partitions) {
            System.out.println(p);
        }
    }

}
