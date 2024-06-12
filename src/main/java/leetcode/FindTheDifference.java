package leetcode;


/**
 * https://leetcode.com/problems/find-the-difference/
 *
 */
public class FindTheDifference {

    private static int[] o = new int[26];

    public static char findTheDifference(String s, String t) {
        for (char c: s.toCharArray()) {
            o[c-'a']++;
        }
        for (char c: t.toCharArray()) {
            o[c-'a']--;
        }
        for (int i = 0; i < o.length; i++) {
            if (o[i] < 0) return (char) (i + 'a');
        }
        return 'a';
    }

    public static char findTheDifference_withxor(String s, String t) {
        char c = 0;
        for (char a: s.toCharArray()) {
            c ^= a;
        }
        for (char b: t.toCharArray()) {
            c ^= b;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(
            findTheDifference_withxor(
                "abcd", "abcde"
            )
        );

    }

}
