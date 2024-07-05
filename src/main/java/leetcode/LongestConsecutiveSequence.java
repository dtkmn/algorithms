package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">128. Longest Consecutive Sequence</a>
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int prev = nums[0] - 1;
        int max = 0;
        int count = 0;
        for (int n: nums) {
            if (n - prev > 1) {
                max = Math.max(max, count);
                count = 1;
            } else if (n - prev == 1) {
                count++;
            }
            prev = n;
        }
        return Math.max(max, count);
    }

    public int longestConsecutive_hashset(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n: nums) {
            s.add(n);
        }
        int max = 0;
        for (int v: s) {
            if (!s.contains(v - 1)) {
                // Start of the sequence
                int count = 1;
                int current = v + 1;
                while (s.contains(current)) {
                    count++;
                    current++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
