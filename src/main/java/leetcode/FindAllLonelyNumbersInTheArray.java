package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/">...</a>
 */
public class FindAllLonelyNumbersInTheArray {

    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num: nums) {
            countMap.put(num, 1 + countMap.getOrDefault(num, 0));
        }
        for (int key: countMap.keySet()) {
            if (!(countMap.get(key) > 1 || countMap.containsKey(key - 1) || countMap.containsKey(key + 1)))
                ans.add(key);
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
