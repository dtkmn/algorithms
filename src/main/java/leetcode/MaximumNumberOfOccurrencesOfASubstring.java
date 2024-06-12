package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/">...</a>
 *
 */
public class MaximumNumberOfOccurrencesOfASubstring {

    private Map<String, Integer> countMap = new HashMap<>();
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        int range = len - minSize + 1;
        int max = 0;
        for (int i = 0; i < range; i++) {
            String sub = s.substring(i, i+minSize);
            if (!validSubString(sub, maxLetters)) continue;
            countMap.put(sub, 1 + countMap.getOrDefault(sub, 0));
        }
        for (int count: countMap.values()) {
            if (count > max) max = count;
        }
        return max;
    }

    private boolean validSubString(String word, int maxLetters) {
        int[] countArray = new int[26];
        for (char c: word.toCharArray()) {
            countArray[c-'a']++;
        }
        int count = 0;
        for (int item: countArray) {
            if (item > 0) count++;
        }
        return count <= maxLetters;
    }

    public static void main(String[] args) {
//        System.out.println(
//            new MaximumNumberOfOccurrencesOfASubstring().maxFreq(
//                "aaaa", 1, 3,3
//            )
//        );
//        System.out.println(
//            new MaximumNumberOfOccurrencesOfASubstring().maxFreq(
//                "aababcaab", 2, 3,4
//            )
//        );
        System.out.println(
            new MaximumNumberOfOccurrencesOfASubstring().maxFreq(
                "abeeadcdbceedccdabcd", 4, 2,3
            )
        );
    }

}
