package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    static class CountValue {

        int key;
        int count;

        public CountValue(int key, int count) {
            this.key = key;
            this.count = count;
        }

    }

    // 10ms
    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<CountValue> countList = new ArrayList<>();
        for (int key: countMap.keySet()) {
            countList.add(new CountValue(key, countMap.get(key)));
        }

        Collections.sort(countList, new Comparator<CountValue>() {
            @Override
            public int compare(CountValue o1, CountValue o2) {
                return o2.count - o1.count;
            }
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(countList.get(i).key);
        }

        return result;

    }

    // 9ms
    public static List<Integer> topKFrequentWithPriorityQueue(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        queue.addAll(countMap.entrySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(queue.poll().getKey());
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(topKFrequentWithPriorityQueue(new int[]{1,1,1,2,2,3}, 2));
        System.out.println(topKFrequentWithPriorityQueue(new int[]{1}, 1));
    }

}
