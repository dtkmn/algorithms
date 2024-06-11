package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/relative-sort-array/">1122. Relative Sort Array</a>
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a: arr1) {
            countMap.put(a, 1 + countMap.getOrDefault(a, 0));
        }

        int pos = 0;
        int[] ans = new int[arr1.length];

        for (int i = 0; i < arr2.length; i++) {
            int count = countMap.get(arr2[i]);
            for (int j = 0; j < count; j++) {
                ans[pos++] = arr2[i];
            }
            countMap.remove(arr2[i]);
        }

        ArrayList<Integer> list = new ArrayList<>(countMap.keySet());
        Collections.sort(list);
        for (int item: list) {
            int count = countMap.get(item);
            for (int j = 0; j < count; j++) {
                ans[pos++] = item;
            }
            countMap.remove(item);
        }
        return ans;
    }

}
