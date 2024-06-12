package leetcode;


/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">...</a>
 *
 */
public class LongestCommonPrefix {

    class Node {
        Node[] nodes = new Node[26];
        int count = 0;
    }

    public String longestCommonPrefix(String[] strs) {
        Node root = new Node();
        for (String str: strs) {
            insert(str, root);
        }
        StringBuilder ans = new StringBuilder();
        Node current = root;
        Node prev = root;
        boolean found = false;
        while (current == root || found) {
            found = false;
            for (int i = 0; i < current.nodes.length; i++) {
                if (current.nodes[i] != null && current.nodes[i].count == strs.length) {
                    ans.append((char)('a' + i));
                    prev = current;
                    current = prev.nodes[i];
                    found = true;
                    break;
                }
            }
        }
        return ans.toString();
    }

    public void insert(String word, Node root) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (current.nodes[c - 'a'] == null)
                current.nodes[c - 'a'] = new Node();
            current.nodes[c-'a'].count++;
            current = current.nodes[c-'a'];
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new LongestCommonPrefix().longestCommonPrefix(new String[] {
               "flower","flow","flight"
            })
        );
    }

}
