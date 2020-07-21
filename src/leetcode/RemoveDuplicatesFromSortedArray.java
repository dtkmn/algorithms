package leetcode;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int l = 0, r = 0, len = nums.length;
        while (++r < len) {
            if (nums[l] != nums[r]) nums[++l] = nums[r];
        }
        return l + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 2 };
        int res = removeDuplicates(input);
        for (int i = 0; i < res; i++) {
            System.out.print(input[i] + " ");
        }
    }

}
