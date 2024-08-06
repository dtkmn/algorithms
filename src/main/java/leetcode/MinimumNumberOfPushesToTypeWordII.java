package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii">3016. Minimum Number of Pushes to Type Word II</a>
 *
 */
public class MinimumNumberOfPushesToTypeWordII {

    public int minimumPushes(String word) {
        int[] countMap = new int[26];
        for (char c: word.toCharArray()) {
            countMap[c - 'a']++;
        }
        Arrays.sort(countMap);
        int count = 0, push = 0;
        for (int i = countMap.length - 1; i >= 0; i--) {
            if (countMap[i] == 0) {
                break;
            }
            push += countMap[i] * (1 + count++ / 8);
        }
        return push;
    }

}
