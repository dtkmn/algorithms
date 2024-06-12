package leetcode;


import java.util.*;

/**
 *  <a href="https://leetcode.com/problems/odd-string-difference/">...</a>
 */
public class OddStringDifference {

    public String oddString(String[] words) {
        Map<List<Integer>, Integer> count = new HashMap<>();
        Map<List<Integer>, String> mapString = new HashMap<>();
        for (String w : words) {
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < w.length() - 1; i++) {
                int d = w.charAt(i + 1) - w.charAt(i);
                array.add(d);
            }
            mapString.put(array, w);
            count.put(array, 1 + count.getOrDefault(array, 0));
        }
        for (List<Integer> key: count.keySet()) {
            if (count.get(key) == 1) return mapString.get(key);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = new OddStringDifference().oddString(
                new String[]{
                        "adc", "wzy", "abc"
                }
        );
        System.out.println(s);
    }


}
