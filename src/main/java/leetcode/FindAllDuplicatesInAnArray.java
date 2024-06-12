package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 *  <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/">...</a>
 */

public class FindAllDuplicatesInAnArray {
    /**
     * Time Complexity: O(N) length of input nums array
     * Space Complexity: O(N) length of input nums array
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int n: nums) {
            count[n]++;
            if (count[n] == 2) ans.add(n);
        }
        return ans;
    }

    /**
     * Time Complexity: O(N) length of input nums array
     * Space Complexity: O(1) constant space exclude output list
     *
     * Multiply the element value with -1 when first visit, when the same element got revisited again, add into the list
     * @param nums
     * @return
     */
    public List<Integer> findDuplicatesNoExtraSpace(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int n: nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) nums[index] *= -1;
            else {
                ans.add(index + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
