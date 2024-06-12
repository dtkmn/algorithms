package leetcode;


import java.util.Stack;

/*
    https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    private Stack<Integer> stack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for (String token: tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int div = stack.pop();
                    stack.push(stack.pop() / div);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(
            new EvaluateReversePolishNotation().evalRPN(new String[] {
                    "4","13","5","/","+"
            })
        );
    }
}
