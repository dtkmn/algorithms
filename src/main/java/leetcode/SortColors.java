package leetcode;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 */
public class SortColors {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public void sortColors(int[] nums) {
        int lo = 0, md = 0, hi = nums.length - 1;
        while (md <= hi) {
            if (nums[md] == 0) {
                swap(nums, lo++, md++);
            } else if (nums[md] == 1) {
                md++;
            } else {
                swap(nums, md, hi--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
