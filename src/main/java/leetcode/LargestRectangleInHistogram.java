package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">...</a>
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int[] maxEach = new int[heights.length];

        int max = 0;
        maxEach[0] = heights[0];
        max = heights[0];
        int i = 1;
        while (i < heights.length) {
            maxEach[i] = heights[i];
            for (int j = 0; j <= i; j++) {
                maxEach[j] = Math.min(maxEach[j], heights[i]);
                int area = maxEach[j] * (i - j + 1);
                max = Math.max(max, area);
            }
            i++;
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            // Push the index onto the stack when the current height is greater than the stack's top height
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                // Calculate area for the top height in the stack
                int top = stack.pop();
                // If stack is empty, width is i, otherwise width is 'i - stack top - 1'
                int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        // Calculate area for remaining bars in stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(
            new LargestRectangleInHistogram().largestRectangleArea2(
                new int[] {2,1,5,6,2,3}
            )
        );
    }

}
