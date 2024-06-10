package leetcode;

/**
 * <a href="https://leetcode.com/problems/substrings-that-begin-and-end-with-the-same-letter/">2083. Substrings That Begin and End With the Same Letter</a>
 */
public class SubstringsThatBeginAndEndWithTheSameLetter {

    public long numberOfSubstrings(String s) {
        int[] countMap = new int[26];
        long count = 0;
        for (char c: s.toCharArray()) {
            if (countMap[c - 'a'] > 0) {
                count += countMap[c - 'a'];
            }
            countMap[c - 'a']++;
        }
        return count + s.length();
    }

}
