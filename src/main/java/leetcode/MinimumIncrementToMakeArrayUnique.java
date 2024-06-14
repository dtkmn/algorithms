package leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-increment-to-make-array-unique/">945. Minimum Increment to Make Array Unique</a>
 */
public class MinimumIncrementToMakeArrayUnique {

     public int minIncrementForUnique1(int[] nums) {
         Arrays.sort(nums);
         int ans = 0;
         int min = nums[0];
         for (int i = 1; i < nums.length; i++) {
             if (min == nums[i]) {
                 min = nums[i] + 1;
                 ans++;
             } else if (min > nums[i]) {
                 ans += min - nums[i] + 1;
                 min++;
             } else {
                 min = nums[i];
             }
         }
         return ans;
     }

    public int minIncrementForUnique2(int[] nums) {
        // To perform faster by guessing the range as usual :D
        int[] countMap = new int[101001];
        for (int n: nums) {
            countMap[n]++;
        }
        int ans = 0, i = 0;
        for (; i < countMap.length; i++) {
            if (countMap[i] > 1) {
                int extra = countMap[i] - 1;
                countMap[i + 1] += extra;
                ans += extra;
            }
        }
        return ans;
    }

}
