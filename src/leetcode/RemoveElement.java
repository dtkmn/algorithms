package leetcode;


/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == val ? 0: 1;

        // Two pointers approach
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != val) l++;
            else if (nums[r] == val) r--;
            else {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        // System.out.println(Arrays.toString(nums));
        // System.out.println(l);

        return l;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 2, 2, 3 };
        int res = removeElement(input, 3);
        for (int i = 0; i < res; i++) {
            System.out.print(input[i] + " ");
        }
    }

}
