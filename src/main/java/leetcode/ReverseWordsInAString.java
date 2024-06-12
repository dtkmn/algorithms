package leetcode;


/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            res.append(strings[i]).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

}
