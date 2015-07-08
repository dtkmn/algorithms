package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dtkmn on 8/07/2015.
 */
public class LargestRect {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] height = new int[N];
        for(int i = 0; i < N; i++) {
            height[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && height[i]<=height[stack.peek()])
            {
                int index = stack.pop();
                int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index=stack.pop();
            int wid=stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
            max=Math.max(wid, max);
        }

        System.out.println(max);
    }

}
