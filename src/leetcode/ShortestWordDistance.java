package leetcode;


/**
 * https://leetcode.com/problems/shortest-word-distance/
 */
public class ShortestWordDistance {

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int shortestDistance(String[] words, String word1, String word2) {
        int w1 = -1, w2 = -1, len = words.length;
        int res = len;
        for (int i = 0; i < len; i++) {
            if (word1.equals(words[i])) {
                w1 = i;
                if (w2 != -1) res = Math.min(res, w1 - w2);
            } else if (word2.equals(words[i])) {
                w2 = i;
                if (w1 != -1) res = Math.min(res, w2 - w1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
                "coding", "practice"));
        System.out.println(shortestDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" },
                "makes", "coding"));
    }

}
