package leetcode;

/**
 *  <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">...</a>
 *
 */
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int lo = 0, hi = s.length() - 1;
        int mid = lo + (hi - lo) / 2;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i <= mid; i++) {
            if (isVowels(cs[i])) leftCount++;
        }
        for (int i = mid + 1; i <= hi; i++) {
            if (isVowels(cs[i])) rightCount++;
        }
        return leftCount == rightCount;
    }

    public boolean isVowels(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {

    }

}
