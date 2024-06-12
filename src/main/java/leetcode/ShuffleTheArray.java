package leetcode;


/**
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleTheArray {

    // Time Complexity: O(N/2)
    // Space Complexity: O(N)
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length - 1; i+=2, j++) {
            res[i] = nums[j];
            res[i + 1] = nums[j + n];
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
