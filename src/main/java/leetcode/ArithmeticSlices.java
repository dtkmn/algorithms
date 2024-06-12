package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/arithmetic-slices/">...</a>
 */
public class ArithmeticSlices {

    private int ans = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> countMap[] = new HashMap[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (countMap[i] == null) countMap[i] = new HashMap<>();
            int j = i - 1;
            if (countMap[j] == null) countMap[j] = new HashMap<>();
            int diff = nums[i] - nums[j];
            int subTotal = 1 + countMap[j].getOrDefault(diff, 0);
            countMap[i].put(diff, subTotal);
            ans += (subTotal - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int slices = new ArithmeticSlices().numberOfArithmeticSlices(
                new int[]{1, 2, 3, 4 ,5 ,6}
        );
        System.out.println(slices);
//
//        int slices2 = new ArithmeticSlices().numberOfArithmeticSlices(
//                new int[]{1, 3, 5, 7, 9}
//        );
//        System.out.println(slices2);

//        int slices3 = new ArithmeticSlices().numberOfArithmeticSlices(
//                new int[]{1, 2, 3, 4, 5, 6}
//        );
//        System.out.println(slices3);
    }

}
