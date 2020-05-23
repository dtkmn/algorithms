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

    // Time Complexity: O(NlogN) i.e N is length of s
    // Space Complexity: O(N)
    public static String frequencySort2(String s) {

        // Make it as char array and sort it

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        System.out.println(Arrays.toString(charArray));

        // Group the same character as same string
        char prev = '0';
        StringBuilder sb = new StringBuilder();
        List<String> dup = new ArrayList<>();
        for (char c: charArray) {
            if (prev == c) {
                sb.append(c);
            } else {
                if (sb.length() > 0) dup.add(sb.toString());
                sb = new StringBuilder();
                sb.append(c);
            }
            prev = c;
        }
        if (sb.length() > 0) dup.add(sb.toString());

        System.out.println(dup);

        Collections.sort(dup, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return 0;
                else return o2.length() > o1.length() ? 1: -1;
            }
        });

        System.out.println(dup);

        StringBuilder res = new StringBuilder();
        for (String item: dup) {
            res.append(item);
        }

        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(frequencySort2("atree"));
        System.out.println(frequencySort2("cccaaa"));
    }

}
