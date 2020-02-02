package leetcode;

/*
   https://leetcode.com/problems/valid-parentheses/
 */


import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(
            isValid("()")
        );
        System.out.println(
            isValid("([)]")
        );
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') return false;
                stack.push(c);
            }
            else {
                char p = stack.peek();
                if ((p == '{' && c == '}') ||
                    (p == '(' && c == ')') ||
                    (p == '[' && c == ']')) {
                    stack.pop();
                } else stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
