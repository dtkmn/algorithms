package leetcode;


import java.util.*;

/*
    https://leetcode.com/problems/time-based-key-value-store/
 */
public class TimeBasedKeyValueStore {

    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    private Map<String, List<Pair>> mapWithinMap;

    public TimeBasedKeyValueStore() {
        mapWithinMap = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        List<Pair> values = mapWithinMap.getOrDefault(key, new ArrayList<>());
        values.add(new Pair(timestamp, value));
        mapWithinMap.put(key, values);
    }

    public String get(String key, int timestamp) {
        List<Pair> integerStringMap = mapWithinMap.get(key);
        if (integerStringMap == null || integerStringMap.isEmpty()) return "";

        int left = 0, right = integerStringMap.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (integerStringMap.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (right == 0) return "";

        return integerStringMap.get(right).value;
    }

    public static void main(String[] args) {

    }



}
