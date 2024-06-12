package leetcode;


/*
    https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWordDataStructureDesign {

    private class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            if (current.nodes[c - 'a'] == null)
                current.nodes[c - 'a'] = new TrieNode();
            current = current.nodes[c - 'a'];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInMiddleWitCharArray(word.toCharArray(), 0, root);
    }

    // 35ms beat ~98.5%
    private boolean searchInMiddleWitCharArray(char[] word, int pos, TrieNode start) {
        if (start == null) return false;
        TrieNode current = start;
        for (int i = pos; i < word.length; i++) {
            if (word[i] == '.') {
                // Skip this character directly
                for (TrieNode t: current.nodes) {
                    if(searchInMiddleWitCharArray(word, i + 1, t)) return true;
                }
                return false;
            }
            else if (current.nodes[word[i] - 'a'] == null) return false;
            else {
                current = current.nodes[word[i] - 'a'];
            }
        }
        return current.isWord;
    }

    // 49ms
    private boolean searchInMiddle(String word, TrieNode start) {
        if (start == null) return false;
        TrieNode current = start;
        char[] input = word.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '.') {
                // Skip this character directly
                String w = word.substring(i + 1);
                for (TrieNode t: current.nodes) {
                    if(searchInMiddle(w, t)) return true;
                }
                return false;
            }
            else if (current.nodes[input[i] - 'a'] == null) return false;
            else {
                current = current.nodes[input[i] - 'a'];
            }
        }
        return current.isWord;
    }

    public static void main(String[] args) {

        AddAndSearchWordDataStructureDesign a = new AddAndSearchWordDataStructureDesign();
        a.addWord("bad");
        a.addWord("dad");
        a.addWord("mad");
        System.out.println(a.search("pad")); // false
        System.out.println(a.search("bad")); // true
        System.out.println(a.search(".ad")); // true
        System.out.println(a.search("b..")); // true

    }


}
