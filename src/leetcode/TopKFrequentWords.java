package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords {

    // 4ms
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word: words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) return o1.getKey().compareTo(o2.getKey());
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        queue.addAll(countMap.entrySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) result.add(queue.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

}
