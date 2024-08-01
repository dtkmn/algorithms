package leetcode;


/**
 * <a href="https://leetcode.com/problems/reverse-vowels-of-a-string">345. Reverse Vowels of a String</a>
 *
 */
public class ReverseVowelsOfString {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] input = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && vowels.indexOf(input[start]) == -1) {
                start++;
            }
            while (end >= 0 && vowels.indexOf(input[end]) == -1) {
                end--;
            }
            if (start < end) {
                char temp = input[start];
                input[start] = input[end];
                input[end] = temp;
                start++;
                end--;
            }
        }
        return new String(input);
    }

}
