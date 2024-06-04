package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-palindrome/">...</a>
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            countMap.put(c, 1 + countMap.getOrDefault(c, 0));
        }
        int count = 0;
        boolean hasSingle = false;
        for (Map.Entry<Character, Integer> e: countMap.entrySet()) {
            int v = e.getValue();
            if (v % 2 == 0) {
                count += v;
            } else {
                hasSingle = true;
                count += (v - 1);
            }
        }
        return hasSingle? count + 1: count;
    }

}
