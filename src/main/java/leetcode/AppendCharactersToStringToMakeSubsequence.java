package leetcode;

/**
 * <a href="https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/">...</a>
 */
public class AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int sPtr = 0;
        int tPtr = 0;
        while (sPtr < sLen && tPtr < tLen) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) {
                tPtr++;
            }
            sPtr++;
        }

        if (tPtr < tLen) {
            return tLen - tPtr;
        }

        return 0;
    }

}
