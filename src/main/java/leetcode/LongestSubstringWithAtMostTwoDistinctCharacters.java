package leetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aaaaaaabc"));
    }

    // Using 2 pointers approach with HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(1) or 2 max in any time
    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        // Length of input string
        int len = s.length();
        // Storing characters and their count
        Map<Character, Integer> map = new HashMap<>();

        // Using 2 pointers to first and second character
        int head = 0, i = 0;
        // Storing current size and max size
        int res = 0;

        while (i < len) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                // When it's new character
                // Check if the size of map is already 2
                while (map.size() >= 2) {
                    // Remove the character on head index
                    char remove = s.charAt(head);
                    if (map.get(remove) <= 1) map.remove(remove);
                    else map.put(remove, map.get(remove) - 1);
                    head++;
                }
                map.put(c, 1);
            }
            res = Math.max(res, i - head + 1);
            i++;
        }

        return res;
    }

}
