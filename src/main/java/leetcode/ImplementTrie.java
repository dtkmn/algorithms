package leetcode;


import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTrie {

    private class TrieNode {
        // 39ms
//        Map<Character, TrieNode> trieNode = new HashMap<>();
        // 29ms
        TrieNode[] trieNode = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.trieNode[c - 'a'] == null) {
                node.trieNode[c - 'a'] = new TrieNode();
            }
            node = node.trieNode[c - 'a'];
//            if (!node.trieNode.containsKey(c)) {
//                node.trieNode.put(c, new TrieNode());
//            }
//            node = node.trieNode.get(c);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.trieNode[c - 'a'] == null) return false;
            node = node.trieNode[c - 'a'];
//            if (!node.trieNode.containsKey(c)) return false;
//            node = node.trieNode.get(c);
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            if (node.trieNode[c - 'a'] == null) return false;
            node = node.trieNode[c - 'a'];
//            if (!node.trieNode.containsKey(c)) return false;
//            node = node.trieNode.get(c);
        }
        return true;
    }

    public static void main(String[] args) {

        ImplementTrie trie = new ImplementTrie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app"));       // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }


}
