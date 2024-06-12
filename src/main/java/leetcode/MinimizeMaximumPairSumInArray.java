package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/">...</a>
 */
public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            max = Math.max(max, nums[i] + nums[j]);
        }
        return max;
    }

    public static void main(String[] args) {
    }

}
