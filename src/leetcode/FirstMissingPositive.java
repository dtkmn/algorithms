package leetcode;


import java.util.HashSet;
import java.util.Set;

/**
 *  <a href="https://leetcode.com/problems/first-missing-positive/">...</a>
 */

public class FirstMissingPositive {

    /**
     * Time Complexity: O(N) length of nums array
     * Space Complexity: O(N) lengtgh of nums array
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int n: nums) {
            visited.add(n);
        }
        int ans = 1;
        while (visited.contains(ans)) {
            ans++;
        }
        return ans;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * Using Cycle Sort to achieve O(1) space
     * @param nums
     * @return
     */
    public int firstMissingPositiveV2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currentVal = nums[i];
            while (currentVal > 0 && currentVal <= nums.length) {
                int correctIndex = currentVal - 1;
                if (i != correctIndex) {
                    int swapValue = nums[correctIndex];
                    if (swapValue == currentVal) break;
                    nums[correctIndex] = currentVal;
                    nums[i] = swapValue;
                } else break;
                currentVal = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            new FirstMissingPositive().firstMissingPositiveV2(
                new int[] { 1, 2, 0 }
            )
        );
    }

}
