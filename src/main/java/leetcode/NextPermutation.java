package leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = -1;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int swap = nums[i - 1];
                int swapIndex = i - 1;
                int next = 0;
                int nextIndex = 0;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > swap) {
                        if (next == 0) next = nums[j];
                        else {
                            if (nums[j] < next) {
                                next = nums[j];
                            }
                        }
                        nextIndex = j;
                    }
                }

                int temp = nums[nextIndex];
                nums[nextIndex] = nums[swapIndex];
                nums[swapIndex] = temp;

                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        if (i == 0) Arrays.sort(nums);
    }

    public static void main(String[] args) {

    }



}
