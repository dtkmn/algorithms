package leetcode;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/set-mismatch/">...</a>
 */
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int num: nums) {
            count[num]++;
        }
        int missing = -1;
        int duplicate = -1;
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) missing = i;
            if (count[i] > 1) duplicate = i;
        }
        return new int[] { duplicate, missing };
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 3, 4, 6, 5};
        int[] errorNums = new SetMismatch().findErrorNums(input);
        System.out.println(Arrays.toString(errorNums));

        int xor = 0;
        for (int i = 0; i < input.length; i++) {
            xor ^= input[i];
            xor ^= (i + 1);
        }
        System.out.println(xor);

        System.out.println(1^2^3^4^3^2^3^4);

    }

}
