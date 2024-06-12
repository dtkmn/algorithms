package leetcode;

/**
 * https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
 *
 */

public class MakeStringASubsequenceUsingCyclicIncrements {

    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrements sys = new MakeStringASubsequenceUsingCyclicIncrements();
        System.out.println(sys.canMakeSubsequence("abc", "ad"));
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < str1.length()) {
            if (ptr2 == str2.length()) return true;
            char c1 = str1.charAt(ptr1);
            char c2 = str2.charAt(ptr2);
            ptr1++;
            char next = c1 == 'z'? 'a': (char) (c1 + 1);
            if (c1 == c2 || next == c2) {
                ptr2++;
            }
        }
        return ptr2 == str2.length();
    }
}
