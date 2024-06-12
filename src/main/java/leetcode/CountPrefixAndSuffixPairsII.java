package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/">3045. Count Prefix and Suffix Pairs II</a>
 */

public class CountPrefixAndSuffixPairsII {

    private Map<String, TrieNode> rootMap;
    private Map<String[], Boolean> resultMap;

    public long countPrefixSuffixPairs(String[] words) {
        rootMap = new HashMap<>();
        resultMap = new HashMap<>();
        long count = 0;
        for (int i = 1; i < words.length; i++) {
            if (!rootMap.containsKey(words[i])) {
                insert(words[i]);
                String reverse = new StringBuilder(words[i]).reverse().toString();
                if (!reverse.equals(words[i])) {
                    insert(reverse);
                }
            }
        }
        for (int m = 0; m < words.length - 1; m++) {
            for (int n = m + 1; n < words.length; n++) {
                if (search(words[n], words[m])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
    }

    private void insert(String word) {
        TrieNode root1  = new TrieNode();
        TrieNode current = root1;
        for (char c: word.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                current.nodes[c - 'a'] = new TrieNode();
            }
            current = current.nodes[c - 'a'];
        }
        rootMap.put(word, root1);
    }

    private boolean search(String main, String word) {
        if (resultMap.containsKey(new String[] {main, word})) {
            return resultMap.get(new String[] {main, word});
        }
        TrieNode root1 = rootMap.get(main);
        TrieNode root2 = rootMap.get(new StringBuilder(main).reverse().toString());
        int i = 0, j = word.length() - 1;
        char[] charArray = word.toCharArray();
        for (; i < word.length() && j >= 0; i++, j--) {
            char c1 = charArray[i];
            char c2 = charArray[j];
            if (root1.nodes[c1 - 'a'] == null || root2.nodes[c2 - 'a'] == null) {
                return false;
            }
            root1 = root1.nodes[c1 - 'a'];
            root2 = root2.nodes[c2 - 'a'];
        }
        resultMap.put(new String[]{main, word}, true);
        return true;
    }

}
