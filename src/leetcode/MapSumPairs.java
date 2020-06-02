package leetcode;


/*
    https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSumPairs {

    private class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        int score;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSumPairs() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode current = root;
        for (char c: key.toCharArray()) {
            if (current.nodes[c - 'a'] == null)
                current.nodes[c - 'a'] = new TrieNode();
            current = current.nodes[c - 'a'];
        }
        current.score = val;
    }

    public int sum(String prefix) {
        TrieNode current = root;
        for (char c: prefix.toCharArray()) {
            if (current.nodes[c - 'a'] == null) return 0;
            current = current.nodes[c - 'a'];
        }
        // Calculate sum start from here
        return getAllScore(current);
    }

    private int getAllScore(TrieNode node) {
        if (node == null) return 0;
        int sum = node.score;
        for (TrieNode n: node.nodes) {
            sum += getAllScore(n);
        }
        return sum;
    }

    public static void main(String[] args) {

        MapSumPairs trie = new MapSumPairs();

        trie.insert("apple", 3);
        System.out.println(trie.sum("ap"));
        trie.insert("app", 2);
        System.out.println(trie.sum("ap"));

    }


}
