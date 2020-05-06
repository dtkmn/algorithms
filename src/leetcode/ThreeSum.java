package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    // Time Complexity: O(n2)
    // Space Complexity: O(1)
    public static List<List<Integer>> threeSum(int[] nums) {

        // Sort input array with O(nlogn)
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        // Time Complexity: O(n)
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int val = nums[i];
                int start = i + 1, end = nums.length - 1;
                // Time Complexity: O(n)
                while (start < end) {
                    int localSum = val + nums[start] + nums[end];
                    // Move the 'end' when localSum > 0  and also when it has same value as previous 'end'
                    if (localSum > 0 || (end < nums.length - 1 && nums[end] == nums[end + 1])) end--;
                    // Same idea for 'start' when localSum < 0 and also when it has same value as previous 'start'
                    else if (localSum < 0 || (start - 1 > i && nums[start] == nums[start - 1])) start++;
                    // Update both 'start' and 'end' here
                    else res.add(Arrays.asList(val, nums[start++], nums[end--]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[] {-2, 0, 0, 2, 2}));
    }

}
