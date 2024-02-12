package leetcode;


/**
 * <a href="https://leetcode.com/problems/majority-element/">...</a>
 *
 */

public class MajorityElement {

    /**
     * Boyer–Moore majority vote algorithm :D
     * Time complexity: O(N)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int current = 0;
        for (int num: nums) {
            if (count == 0) current = num;
            if (num == current) count++;
            else count--;
        }
        return current;
    }
    public static void main(String[] args) {
    }

}
