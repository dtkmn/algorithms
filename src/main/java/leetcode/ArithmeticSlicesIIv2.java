package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/arithmetic-slices-ii-subsequence">...</a>
 */
public class ArithmeticSlicesIIv2 {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        int length = nums.length;
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            Map<Integer, Integer> currentMap = m.getOrDefault(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                if (d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
                    total += 1;
                    continue;
                }
                int diff = (int)d;
                Map<Integer, Integer> subMap = m.getOrDefault(j, new HashMap<>());
                int subValue = subMap.getOrDefault(diff, 0);
                int subtotal = 1 + subValue + currentMap.getOrDefault(diff, 0);
                total += 1 + subValue;
                currentMap.put(diff, subtotal);
            }
            m.put(i, currentMap);
        }
        return total - (length * (length - 1) / 2);
    }

    public static void main(String[] args) {
        int slices = new ArithmeticSlicesIIv2().numberOfArithmeticSlices(
                new int[]{1,2,3,4,5,6}
        );
        System.out.println(slices);
        // 12

//        int slices = new ArithmeticSlicesIIv2().numberOfArithmeticSlices(
//                new int[]{7,7,7,7,7}
//        );
//        System.out.println(slices);

        int slices2 = new ArithmeticSlicesIIv2().numberOfArithmeticSlices(
                new int[]{0,2000000000,-294967296}
        );
        System.out.println(slices2);

//        int slices2 = new ArithmeticSlicesIIv2().numberOfArithmeticSlices(
//                new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
//        );
//        System.out.println(slices2);
        // 536870476

//
//        int slices2 = new ArithmeticSlices().numberOfArithmeticSlices(
//                new int[]{1, 3, 5, 7, 9}
//        );
//        System.out.println(slices2);

//        int slices3 = new ArithmeticSlicesII().numberOfArithmeticSlices(
//                new int[]{2,4,6,8,10}
//        );
//        System.out.println("--- " + slices3);
//
//        int slices4 = new ArithmeticSlicesII().numberOfArithmeticSlices(
//                new int[]{7,7,7,7,7}
//        );
//        System.out.println("--- " + slices4);
    }

}
