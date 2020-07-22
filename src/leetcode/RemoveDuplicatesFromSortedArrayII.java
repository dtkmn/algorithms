package leetcode;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

    // Given a sorted array nums, remove the duplicates in-place such that
    // duplicates appeared at most twice and return the new length.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    // 1ms
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        // if length is less than or equal to 2, just return
        if (len <= 2) return len;
        int l = 0, count = 1;
        for (int i = 1; i < len; i++) {
            // advance when it's different
            if (nums[l] != nums[i]) {
                count = 1;
                nums[++l] = nums[i];
            }
            // if same, only advance when count is less than 3
            else if (++count <= 2) {
                nums[++l] = nums[i];
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 0,0,1,1,1,1,2,3,3 };
        int res = removeDuplicates(input);
        for (int i = 0; i < res; i++) {
            System.out.print(input[i] + " ");
        }

    }

}
