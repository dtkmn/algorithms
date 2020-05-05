package leetcode;


/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    // Time Complexity: O(n2)
    // Space Complexity: O(1)
    // 70ms
    // Each index find the left max and right max,
    // Get minimum on both and subtract current height
    public static int trap(int[] height) {
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            int min = Math.min(leftMax, rightMax);
            if (height[i] < min) total += min - height[i];
        }
        return total;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // 1ms
    // Using same concept as above but store the process with dp
    public static int trap_dp(int[] height) {

        if (height.length == 0) return 0;

        int total = 0;

        int[] leftMaxDp = new int[height.length];
        int[] rightMaxDp = new int[height.length];

        leftMaxDp[0] = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (i == 1) leftMaxDp[i] = height[0];
            else leftMaxDp[i] = Math.max(leftMaxDp[i - 1], height[i - 1]);
        }

        rightMaxDp[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (i == height.length - 2) rightMaxDp[i] = height[height.length - 1];
            else rightMaxDp[i] = Math.max(rightMaxDp[i + 1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMaxDp[i], rightMaxDp[i]);
            if (height[i] < min) total += min - height[i];
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap_dp(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

}
