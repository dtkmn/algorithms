package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/the-number-of-beautiful-subsets/">...</a>
 *
 */
public class TheNumberOfBeautifulSubsets {

    private int ans = 0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(nums, k, 0, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int k, int prev, int pos, List<Integer> list) {
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            System.out.println(prev + ":" + i);
            if (list.isEmpty() || stillValid(list, nums[i], k)) {
                list.add(nums[i]);
                ans++;  // We can add one here since single element here
                System.out.println(list);
                backtrack(nums, k, i, i + 1, list);
                list.removeLast();
            }
        }
    }

    private boolean stillValid(List<Integer> list, int p, int k) {
        for (int a: list) {
            if (Math.abs(p - a) == k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int subsets = new TheNumberOfBeautifulSubsets().beautifulSubsets(
                new int[]{2, 4, 6},
                2
        );
        System.out.println(subsets);
    }

}
