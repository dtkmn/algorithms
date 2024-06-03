package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/">...</a>
 */
public class LongestCommonSubsequenceBetweenSortedArrays {

    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int size = arrays.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int[] arr: arrays) {
            for (int a: arr) {
                int count = 1 + countMap.getOrDefault(a, 0);
                countMap.put(a, count);
                if (count == size) {
                    res.add(a);
                }
            }
        }
        return res;
    }

}
