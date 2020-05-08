package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {

    // Time Complexity: O(n2)
    // Space Complexity: O(1)
    // ~800ms
    public static int maxArea(int[] height) {
        int max = 0, sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum = 0;
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                sum += height[i];
                if (height[j] >= height[i]) {
                    leftMax = sum;
                }
            }
            sum = 0;
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                sum += height[i];
                if (height[j] >= height[i]) {
                    rightMax = sum;
                }
            }
            max = Math.max(max, Math.max(leftMax, rightMax));
        }
        return max;
    }

    // Using 2 pointers approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // 2ms
    public static int maxArea_twopointer(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;

        while (start < end) {
            // Find the area in between '2 pointers' with minimum height
            // Advance the pointer to maximize the area if possible
            if (height[start] >= height[end]) {
                int area = height[end] * (end - start);
                max = Math.max(max, area);
                end--;
            } else {
                int area = height[start] * (end - start);
                max = Math.max(max, area);
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea_twopointer(new int[] { 1,8,6,2,5,4,8,3,7 }));
    }

}
