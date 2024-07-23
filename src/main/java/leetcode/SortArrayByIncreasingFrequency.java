package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency/">1636. Sort Array by Increasing Frequency</a>
 */
public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n: nums) {
            countMap.put(n, 1 + countMap.getOrDefault(n, 0));
        }
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        keys.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = countMap.get(o1);
                int count2 = countMap.get(o2);
                if (count1 == count2) {
                    return o2 - o1;
                }
                return count1 - count2;
            }
        });

        int[] ans = new int[nums.length];
        int pos = 0;
        for (int k : keys) {
            int size = countMap.get(k);
            for (int i = 0; i < size; i++) {
                ans[pos++] = k;
            }
        }
        return ans;
    }

}
