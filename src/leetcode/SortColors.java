package leetcode;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int[] sortColors(int[] nums) {

        // Initialize 2 pointers on '0' and '2'
        int posZero = 0, posTwo = nums.length - 1;
        int curr = 0;
        while (curr <= posTwo) {
            if (nums[curr] == 0) {
                swap(nums, curr++, posZero++);
            }
            else if (nums[curr] == 2) {
                // No increment on curr when it's 2
                swap(nums, curr, posTwo--);
            } else curr++;
        }

        return nums;

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortColors(new int[]{ 2, 0, 2, 1, 1, 0 })));
        System.out.println(Arrays.toString(sortColors(new int[]{ 1, 0 })));
        System.out.println(Arrays.toString(sortColors(new int[]{ 1, 2, 0 })));
        System.out.println(Arrays.toString(sortColors(new int[]{ 2, 0, 1 })));

    }

}
