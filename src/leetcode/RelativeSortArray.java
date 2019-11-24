package leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = arrayToMap(arr1);
        int[] output = new int[arr1.length];
        int pos = 0;
        for (int i = 0; i < arr2.length; i++) {
            int v = arr2[i];
            if (map.get(v) != null) {
                int f = map.remove(v);
                for (int a = 0; a < f; a++) {
                    output[pos++] = v;
                }
            }
        }

        Integer[] keysArray = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keysArray, Comparator.comparingInt(o -> o));

        for (int i = 0; i < keysArray.length; i++) {
            int key = keysArray[i];
            int freq = map.get(key);
            for (int k = 0; k < freq; k++) {
                output[pos++] = key;
            }
        }

        // When using TreeMap, no need to sort cuz it happens auto, but it's slower...
//        for (Integer key: map.keySet()) {
//            int freq = map.get(key);
//            for (int k = 0; k < freq; k++) {
//                output[pos++] = key;
//            }
//        }

        return output;

    }

    public static Map<Integer, Integer> arrayToMap(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int v = input[i];
            if (map.get(v) == null) map.put(v, 1);
            else map.put(v, map.get(v) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            relativeSortArray(
                new int[]{2,3,1,3,2,4,6,7,9,2,19},
                new int[]{2,1,4,3,9,6}
            )
        ));
    }

}
