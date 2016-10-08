package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StacksBalancedBrackets {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String open = "{[(";
        String close = "}])";
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            Stack<String> stack = new Stack<>();
            String inputs = br.readLine();
            boolean balanced = true;
            for(int j=0; j<inputs.length(); j++) {
                char c = inputs.charAt(j);
                if(open.indexOf(c) != -1) {
                    stack.push(c+"");
                } else {
                    if(stack.size() == 0) {
                        balanced = false;
                        break;
                    }
                    String popItem = stack.pop();
                    if(popItem == null || (open.indexOf(popItem) != close.indexOf(c))) {
                        balanced = false;
                        break;
                    }
                }
            }
            if(stack.size()!=0) balanced = false;
            System.out.println(balanced?"YES":"NO");
        }

    }

}
