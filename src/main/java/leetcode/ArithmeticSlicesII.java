package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/arithmetic-slices/">...</a>
 */
public class ArithmeticSlicesII {

    private int ans = 0;
    private int[][] dp;
    public int numberOfArithmeticSlices(int[] nums) {
        this.dp = new int[nums.length][nums.length];
        // Sorting first
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
//            dfs(nums[i], i + 1, 1, -1, nums);
            for (int j = i + 1; j < nums.length; j++) {
                // Compare first pair for new diff
                int d = nums[j] - nums[i];
                dfs(nums[j], j + 1, 2, d, nums);
            }
        }
        return ans;
    }

    public void dfs(int prev, int from, int count, int diff, int[] nums) {
        if (count >= 3) {
            ans += 1;
        }

        if (from == nums.length) {
            return;
        }

        for (int i = from; i < nums.length; i++) {
            int current = nums[i];
            if (diff == -1) diff = current - prev;
            if (current - prev == diff) {
//                System.out.println("Here!?");
                dfs(current, i + 1, count + 1, diff, nums);
            }
        }

    }

    public static void main(String[] args) {
        int slices = new ArithmeticSlicesII().numberOfArithmeticSlices(
                new int[]{1, 2, 3, 4, 5, 6}
        );
        System.out.println(slices);
        // 12

        int slices2 = new ArithmeticSlicesII().numberOfArithmeticSlices(
                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        );
        System.out.println(slices2);
        // 536870476

//
//        int slices2 = new ArithmeticSlices().numberOfArithmeticSlices(
//                new int[]{1, 3, 5, 7, 9}
//        );
//        System.out.println(slices2);

//        int slices3 = new ArithmeticSlicesII().numberOfArithmeticSlices(
//                new int[]{2,4,6,8,10}
//        );
//        System.out.println("--- " + slices3);
//
//        int slices4 = new ArithmeticSlicesII().numberOfArithmeticSlices(
//                new int[]{7,7,7,7,7}
//        );
//        System.out.println("--- " + slices4);
    }

}
