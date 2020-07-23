package leetcode;


/**
 * https://leetcode.com/problems/shortest-word-distance-iii/
 */
public class ShortestWordDistanceIII {


    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, len = words.length;
        // Support duplicated words, only difference from 'Shortest word distance I'
        boolean same = word1.equals(word2);
        int res = len;
        for (int i = 0; i < len; i++) {
            if (word1.equals(words[i])) {
                // Handle when word1 equal to word2
                if (same) {
                    w1 = w2;
                    w2 = i;
                } else w1 = i;
                if (w2 != -1 && w1 != -1) res = Math.min(res, Math.abs(w1 - w2));
            } else if (word2.equals(words[i])) {
                w2 = i;
                if (w1 != -1) res = Math.min(res, w2 - w1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
                "coding", "practice"));
        System.out.println(shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
                "makes", "coding"));
        System.out.println(shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
                "makes", "makes"));
    }

}
