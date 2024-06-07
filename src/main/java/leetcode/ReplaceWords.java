package leetcode;


import java.util.List;

/**
 *  <a href="https://leetcode.com/problems/replace-words/">648. Replace Words</a>
 */

public class ReplaceWords {

    class Node {
        Node[] nodes = new Node[26];
        boolean isRoot;
        String word;
    }

    void insert(String word, Node root) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            if (curr.nodes[c - 'a'] == null) {
                curr.nodes[c - 'a'] = new Node();
            }
            curr = curr.nodes[c - 'a'];
        }
        curr.isRoot = true;
        curr.word = word;
    }

    String findRootOrWord(String word, Node root) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            curr = curr.nodes[c - 'a'];
            if (curr != null && curr.isRoot) {
                return curr.word;
            } else if (curr == null){
                return word;
            }
        }
        return word;
    }

    String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        // Insert each word characters into Trie data structure
        for (String word: dictionary) {
            // Under each word within dictionary
            insert(word, root);
        }
        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split(" ")) {
            ans.append(" ").append(findRootOrWord(word, root));
        }
        return ans.toString().trim();
    }

}
