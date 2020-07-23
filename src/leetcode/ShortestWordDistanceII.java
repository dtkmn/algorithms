package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 */
public class ShortestWordDistanceII {

    private Map<String, List<Integer>> mapPos = new HashMap<>();
    private int len;

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public ShortestWordDistanceII(String[] words) {
        this.len = words.length;
        for (int i = 0; i < len; i++) {
            String w = words[i];
            List<Integer> pos = mapPos.getOrDefault(w, new ArrayList<>());
            pos.add(i);
            mapPos.put(w, pos);
        }
    }

    // Time Complexity: O(MAX(word1_list, word2_list) <= N)
    public int shortest(String word1, String word2) {

        List<Integer> w1pos = mapPos.get(word1);
        List<Integer> w2pos = mapPos.get(word2);

        // System.out.println(w1pos);
        // System.out.println(w2pos);

        int res = len;
        int i = 0, j = 0;
        while (i < w1pos.size() && j < w2pos.size()) {
            int p1 = w1pos.get(i);
            int p2 = w2pos.get(j);
            if (p1 > p2) {
                res = Math.min(res, p1 - p2);
                j++;
            } else {
                res = Math.min(res, p2 - p1);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[] { "practice", "makes", "perfect", "coding", "makes" };
        ShortestWordDistanceII sd = new ShortestWordDistanceII(words);
        System.out.println(sd.shortest("coding", "practice"));
        System.out.println(sd.shortest("coding", "makes"));
    }

}
