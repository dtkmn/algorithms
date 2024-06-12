package leetcode;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/">...</a>
 */
public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 0) return -1; // ?
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];

        int[] newDp = new int[grid[0].length];
        int[] oldDp = new int[grid[0].length];
        for (int c = 0; c < grid[0].length; c++) {
            oldDp[c] = grid[grid.length - 1][c];
            newDp[c] = Integer.MAX_VALUE;
        }

        for (int r = grid.length - 1; r > 0; r--) {
            for (int i = 0; i < oldDp.length; i++) {
                for (int j = 0; j < oldDp.length; j++) {
                    if (i != j) {
                        int currentValue = oldDp[i];
                        newDp[j] = Math.min(newDp[j], currentValue + grid[r - 1][j]);
                    }
                }
            }
            System.out.println("----------");
            System.out.println(Arrays.toString(newDp));
            System.out.println("----------");
            oldDp = newDp.clone();
            if (r > 1) Arrays.fill(newDp, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int firstRowItem: newDp) {
            ans = Math.min(ans, firstRowItem);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int minSum = new MinimumFallingPathSumII().minFallingPathSum(
//            new int[][] {
//                {2,1,3},
//                {4,5,6},
//                {7,8,9}
//            }
//        );
//        System.out.println(minSum);

        int minSum2 = new MinimumFallingPathSumII().minFallingPathSum(
                new int[][] {
                        {-73,61,43,-48,-36},
                        {3,30,27,57,10},
                        {96,-76,84,59,-15},
                        {5,-49,76,31,-7},
                        {97,91,61,-46,67}
                }
        );
        System.out.println(minSum2);
    }

}
