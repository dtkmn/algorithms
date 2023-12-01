package leetcode;


/**
 * <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">...</a>
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        for (String w: word1) {
            string1.append(w);
        }
        StringBuilder string2 = new StringBuilder();
        for (String w: word2) {
            string2.append(w);
        }
        return string1.compareTo(string2) == 0;
    }

    public static void main(String[] args) {

    }

}
