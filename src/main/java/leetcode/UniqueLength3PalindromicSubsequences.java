package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">...</a>
 *
 */
public class UniqueLength3PalindromicSubsequences {

    public static int countPalindromicSubsequence(String s) {
        int count = 0;
        char[] charArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int start = s.indexOf(charArray[i]);
            int end = s.lastIndexOf(charArray[i]);
            if (start == -1 || end == -1 || start == end) continue;
            Set<Character> uniqueChar = new HashSet<>();
            for (int j = start + 1; j < end; j++) {
                uniqueChar.add(s.charAt(j));
            }
            count += uniqueChar.size();
        }
        return count;
    }

    public static int countPalindromicSubsequence2(String s) {
        int count = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            int index = sArray[i] - 'a';
            if (first[index] == -1) first[index] = i;
            last[index] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1 || last[i] == -1 || first[i] == last[i]) continue;
            Set<Character> uniqueChar = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                uniqueChar.add(sArray[j]);
            }
            count += uniqueChar.size();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                countPalindromicSubsequence2("bbcbaba")
        );
    }
}
