package leetcode;


import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) stack.push(S.charAt(i));
            else if (stack.peek() == S.charAt(i)) {
                stack.pop();
            } else stack.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static String removeDuplicates_nocollection(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() == 0) sb.append(S.charAt(i));
            else if (S.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
            removeDuplicates_nocollection("abbaca")
        );
    }

}
