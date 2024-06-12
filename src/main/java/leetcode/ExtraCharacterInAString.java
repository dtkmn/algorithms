package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/extra-characters-in-a-string/">...</a>
 */
public class ExtraCharacterInAString {

    class Node {
        Node[] nodes = new Node[26];
        int count = 0;
        boolean isWord = false;
    }

    public void insert(Node root, String word) {
        Node head = root;
        for (char c: word.toCharArray()) {
            if (head.nodes[c - 'a'] == null) {
                head.nodes[c - 'a'] = new Node();
            }
            head.nodes[c - 'a'].count++;
            head = head.nodes[c - 'a'];
        }
        head.isWord = true;
    }

    public int scan(Node root, String word) {
        char[] cc = word.toCharArray();
        int i = 0;
        int count = 0;
        int pre = 0;
        boolean inWord = false;
        Node head = root;
        while (i < cc.length) {
            if (head.nodes[cc[i]-'a'] == null) {
                head = root;
                if (!inWord) {
                    count++;
                    i++;
                }
                inWord = false;
            } else {
                head = head.nodes[cc[i]-'a'];
                inWord = true;
                i++;
            }
        }
        return count;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Node root = new Node();
        for (String word: dictionary) {
            insert(root, word);
        }
        return scan(root, s);
    }

    public static void main(String[] args) {
//        System.out.println(
//            new ExtraCharacterInAString().minExtraChar("leetscode", new String[] {"leet","code","leetcode"})
//        );
//        System.out.println(
//                new ExtraCharacterInAString().minExtraChar("sayhelloworld", new String[] {"hello","world"})
//        );
        System.out.println(
            new ExtraCharacterInAString().minExtraChar("dwmodizxvvbosxxw",
                new String[] {
                    "ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"
                })
        );
    }

}
