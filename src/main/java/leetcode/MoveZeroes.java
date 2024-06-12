package leetcode;


/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        // Pointer to non-zero element ONLY
        int sth = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != sth) {
                    nums[sth] = nums[i];
                    nums[i] = 0;
                }
                sth++;
            }
        }
    }

    public static void main(String[] args) {

    }

}
