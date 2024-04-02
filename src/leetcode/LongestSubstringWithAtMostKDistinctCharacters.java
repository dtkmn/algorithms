package leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/">...</a>
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
    }

    /**
     * Time Complexity: O(N) Length of input string s
     * Space Complexity: O(k) HashMap only store max k key/value pair
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while (left <= right && right < s.length()) {
            char rc = s.charAt(right);
            countMap.put(rc, 1 + countMap.getOrDefault(rc, 0));
            while (countMap.size() > k) {
                char lc = s.charAt(left);
                if (countMap.get(lc) == 1) countMap.remove(lc);
                else countMap.put(lc, countMap.get(lc) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}
