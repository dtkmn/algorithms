package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/">...</a>
 *
 */
public class FrequencyOfTheMostFrequentElement {

    // Sliding window from right to left
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1, right = nums.length - 1;
        long total = 0L;
        for (int left = right; left >= 0; left--) {
            total += nums[left];
            while ((long) nums[right] * (right - left + 1) - total > k) {
                total -= nums[right];
                right--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
            maxFrequency(new int[] {1,2,4}, 5)
        );
    }

}
