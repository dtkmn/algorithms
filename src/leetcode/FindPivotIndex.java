package leetcode;

/**
 * <a href="https://leetcode.com/problems/find-pivot-index/">...</a>
 *
 */
public class FindPivotIndex {

    // Prefix Sum Approach
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int num: nums) sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            pivotIndex(new int[] {1,7,3,6,5,6})
        );
    }

}
