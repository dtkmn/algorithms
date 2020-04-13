package leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        queue.addAll(countMap.entrySet());

        StringBuilder output = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> poll = queue.poll();
            Character key = poll.getKey();
//            output.append(String.valueOf(key).repeat(poll.getValue()));
            for (int i = 0; i < poll.getValue(); i++) {
                output.append(key);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
    }

}
