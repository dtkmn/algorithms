package leetcode;


import java.util.Arrays;
import java.util.List;

/*
    https://leetcode.com/problems/replace-words/
 */
public class ReplaceWords {

    private static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord;
        String word;
    }

    // Time Complexity: O(Length of sentence)
    // Space Complexity: O(Size of Trie)
    public static String replaceWords(List<String> dict, String sentence) {

        // Put all words within dict into Trie
        TrieNode root = new TrieNode();
        for (String word: dict) {
            TrieNode current = root;
            for (char c: word.toCharArray()) {
                if (current.nodes[c - 'a'] == null)
                    current.nodes[c - 'a'] = new TrieNode();
                current = current.nodes[c - 'a'];
            }
            current.isWord = true;
            current.word = word;
        }

        StringBuilder res = new StringBuilder();
        // Every word within sentence
        for (String w: sentence.split(" ")) {
            TrieNode current = root;
            // Loop through every character in each word
            for (char c: w.toCharArray()) {
                if (current.isWord) break;
                if (current.nodes[c - 'a'] == null) break;
                current = current.nodes[c - 'a'];
            }

            if (current.isWord) res.append(current.word);
            else res.append(w);

            res.append(" ");

        }

        return res.toString().trim();

    }

    public static void main(String[] args) {

        System.out.println(replaceWords(Arrays.asList("cat","bat","rat"),
            "the cattle was rattled by the battery"));

    }


}
