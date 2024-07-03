package leetcode;

import java.util.Arrays;

/**
 *      <a href="https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/">1509. Minimum Difference Between Largest and Smallest Value in Three Moves</a>
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        min = Math.min(min, nums[nums.length - 4] - nums[0]);
        min = Math.min(min, nums[nums.length - 3] - nums[1]);
        min = Math.min(min, nums[nums.length - 1] - nums[3]);
        min = Math.min(min, nums[nums.length - 2] - nums[2]);
        return min;
    }

}
