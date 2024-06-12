package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">...</a>
 */

public class LengthOfLongestSubarrayWithAtMostKFrequency {


    /**
     * Time Complexity: O(N) length of input nums array
     * Space Complexity: O(N) length of input nums array
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (left <= right && right < nums.length) {
            int currentCount = countMap.getOrDefault(nums[right], 0);
            if (currentCount < k) {
                maxLength = Math.max(maxLength, right - left + 1);
                countMap.put(nums[right], 1 + currentCount);
                right++;
            } else {
                if (countMap.containsKey(nums[left])) {
                    countMap.put(nums[left], countMap.get(nums[left]) - 1);
                }
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
    }

}
