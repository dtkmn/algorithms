package leetcode;

/*
    https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        // Binary search
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - lo + 1) % 2 == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((hi - mid + 1) % 2 == 0) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {

    }
}
