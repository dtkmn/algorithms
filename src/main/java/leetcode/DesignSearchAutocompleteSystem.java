package leetcode;


import java.util.*;

/*
    https://leetcode.com/problems/design-search-autocomplete-system/
 */
public class DesignSearchAutocompleteSystem {


    class Node {
        List<String> prefixWords = new ArrayList<>();
        Node[] nodes = new Node[27];
    }

    Map<String, Integer> popular = new HashMap<>();
    Node root = new Node();
    String userInput;
    Node userInputNode = root;

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {

            insertNewSentence(sentences[i], times[i]);
//            popular.put(sentences[i], times[i]);
//            Node current = root;
//            for (char c: sentences[i].toCharArray()) {
//                if (c != '#') {
//                    int index = (c != ' ') ? c - 'a' : 26;
//                    Node charNode = null;
//                    if (current.nodes[index] == null) {
//                        current.nodes[index] = new Node();
//                    }
//                    current.nodes[index].prefixWords.add(sentences[i]);
//                    current = current.nodes[index];
//                } else {
//                    break;
//                }
//            }
        }
    }

    public void insertNewSentence(String sentence, int time) {
        popular.put(sentence, time + popular.getOrDefault(sentence, 0));
        Node current = root;
        for (char c: sentence.toCharArray()) {
            if (c != '#') {
                int index = (c != ' ') ? c - 'a' : 26;
                Node charNode = null;
                if (current.nodes[index] == null) {
                    current.nodes[index] = new Node();
                }
                if (!current.nodes[index].prefixWords.contains(sentence))
                    current.nodes[index].prefixWords.add(sentence);
                current = current.nodes[index];
            } else {
                break;
            }
        }
    }


    public List<String> input(char c) {
        if (c == '#') {
            insertNewSentence(userInput, 1);
            userInput = null;
            userInputNode = root;
            return List.of();
        }

        if (userInput == null) userInput = String.valueOf(c);
        else {
            userInput += c;
        }

        int index = (c != ' ') ? c - 'a' : 26;
        Node newUserInputNode = userInputNode.nodes[index];
        if (newUserInputNode == null) {
            return List.of();
        } else {
            List<String> prefixWords = newUserInputNode.prefixWords;
            prefixWords.sort((o1, o2) -> {
                if (popular.get(o2) != popular.get(o1))
                    return popular.get(o2) - popular.get(o1);
                else return o1.compareTo(o2);
            });
            userInputNode = newUserInputNode;
            return prefixWords.size() > 3 ? prefixWords.subList(0, 3) : prefixWords;
        }
    }

    public static void main(String[] args) {
        DesignSearchAutocompleteSystem system = new DesignSearchAutocompleteSystem(
                new String[]{
                        "i love you", "island", "ironman", "i love leetcode"
                },
                new int[]{
                        5, 3, 2, 2
                }
        );
        system.input('i');
        system.input(' ');
        system.input('a');
        system.input('#');
        system.input('i');
        system.input(' ');
        system.input('a');
        system.input('#');
        system.input('i');
        system.input(' ');
        List<String> stringList1 = system.input('a');
        List<String> stringList = system.input('#');
        System.out.println(stringList1.toString());

    }



}
