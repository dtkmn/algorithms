package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/contiguous-array/
 *
 */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {

        int max = 0, sum = 0;
        // Using map to save each sum with index
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // calculate the sum on each value
            sum += nums[i] == 0 ? -1 : 1;
            // Handle the sum from start
            if (sum == 0) max = Math.max(max, i + 1);
            // if existed in map, index should be the first appeared or leftmost within the array
            else if (countMap.containsKey(sum)) {
                max = Math.max(max, i - countMap.get(sum));
            } else countMap.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
        System.out.println(findMaxLength(new int[] {0,0,1,0,0,0,1,1}));

    }

}
