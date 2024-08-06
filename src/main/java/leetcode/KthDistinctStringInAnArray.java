package leetcode;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/kth-distinct-string-in-an-array">2053. Kth Distinct String in an Array</a>
 *
 */
public class KthDistinctStringInAnArray {

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s: arr) {
            countMap.put(s, 1 + countMap.getOrDefault(s, 0));
        }
        int count = 0;
        for (String s: arr) {
            if (countMap.get(s) == 1) {
                if (++count == k) {
                    return s;
                }
            }
        }
        return "";
    }

    public String kthDistinct_linkedasMap(String[] arr, int k) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for (String s: arr) {
            countMap.put(s, 1 + countMap.getOrDefault(s, 0));
        }
        Iterator<String> it = countMap.keySet().iterator();
        int order = 1;
        while (it.hasNext()) {
            String key = it.next();
            if (countMap.get(key) == 1) {
                if (order == k) {
                    return key;
                }
                order++;
            }
        }
        return "";
    }

}
