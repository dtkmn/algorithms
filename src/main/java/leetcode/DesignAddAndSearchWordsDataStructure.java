package leetcode;

/**
 *  <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">211. Design Add and Search Words Data Structure</a>
 */

public class DesignAddAndSearchWordsDataStructure {

    private static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.nodes[c - 'a'] == null) {
                curr.nodes[c - 'a'] = new TrieNode();
            }
            curr = curr.nodes[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, 0, curr);
    }

    private boolean dfs(String word, int pos, TrieNode currentNode) {
        if (pos == word.length()) {
            return currentNode.isWord;
        }
        char c = word.charAt(pos);
        if (c == '.') {
            for (TrieNode node: currentNode.nodes) {
                if (node != null) {
                    if (dfs(word, pos + 1, node)) {
                        return true;
                    }
                }
            }
            return false;
        } else if (currentNode.nodes[c - 'a'] == null) {
            return false;
        } else {
            return dfs(word, pos + 1, currentNode.nodes[c - 'a']);
        }
    }

}
