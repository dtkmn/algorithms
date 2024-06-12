package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 */
public class FindAllAnagramsInaString {

    static boolean allZero(int[] patternCount) {
        for (int count: patternCount) {
            if (count != 0) return false;
        }
        return true;
    }

    // 8ms
    // Using sidling window and two pointers approach
    // Time Complexity: O(Length of s)
    // Space Complexity: O(1) length 26
    public static List<Integer> findAnagrams(String s, String p) {
        int start = 0, end;
        int[] count = new int[26];
        // Increase count on required characters
        for (char c: p.toCharArray()) {
            count[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for (end = 0; end < s.length(); end++) {
            // decrease the count when character was inside sliding window
            count[s.charAt(end)-'a']--;
            // When equal length and match, count on all characters should be zero
            if (end - start + 1 == p.length()) {
                if (allZero(count)) result.add(start);
            }
            // if length is longer, remove the front -> increment the start
            if (end - start + 1 > p.length()) {
                count[s.charAt(start)-'a']++;
                start++;
                if (end - start + 1 == p.length()) {
                    if (allZero(count)) result.add(start);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(
            FindAllAnagramsInaString.findAnagrams("abab", "ab")
        );
    }

}
