package leetcode;

import java.util.*;

/**
 *  <a href="https://leetcode.com/problems/longest-string-chain/">...</a>
 */
public class LongestStringChain {

    private String[] words;
    private int max = 1;

    public int longestStrChain(String[] words) {
        if (words.length < 2) return 1;
        // Sort the array by word length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        this.words = words;
//        System.out.println(words);
        for (int i = 0; i < words.length - 1; i++) {
            backtrack(words[i], i + 1 , 1);
        }
        return max;
    }

    private void backtrack(String previous, int pos, int localCount) {
        if (pos == words.length) {
            max = Math.max(max, localCount);
            return;
        }

        if (pos < words.length) {
            String checkWord = words[pos];
            if (isPredecessor(previous, checkWord)) {
                backtrack(checkWord, pos + 1, localCount + 1);
            } else {
                backtrack(previous, pos + 1, localCount);
            }
        }

    }

    private boolean isPredecessor(String word1, String word2) {
        if (word1.length() >= word2.length()) return false;

        int head1 = 0, tail1 = word1.length() - 1;
        int head2 = 0, tail2 = word2.length() - 1;

        while (head1 <= tail1 && head2 <= tail2) {
            if (word1.charAt(head1) == word2.charAt(head2)) {
                head1++; head2++;
            } else if (word1.charAt(tail1) == word2.charAt(tail2)) {
                tail1--; tail2--;
            } else {
                break;
            }
        }
        return tail2 - head2 + 1 == 1;

//        int i = 0;
//        for (i = 0; i < word1.length(); i++) {
//            if (word1.charAt(i) != word2.charAt(i)) {
//                return word1.substring(i + 1).equals(word2) ||
//                    word2.substring(i + 1).equals(word1);
//            }
//        }
//        return word2.length() - i == 1;
    }

    public int longestStrChain_editoral(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String word : words) {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }


    public int longestStrChain2(String[] words) {
        Arrays.sort(words, (word1, word2) -> word2.length() - word1.length());
        wordSet.addAll(Arrays.asList(words));
        for (String word: words) {
            if (wordsCount.containsKey(word)) {
                longest = Math.max(longest, wordsCount.get(word));
            } else {
                wordsCount.put(word, 1);
                breakit(word, 1);
            }
        }
        return longest;
    }

    private Map<String, Integer> wordsCount = new HashMap<>();
    private Set<String> wordSet = new HashSet<>();
    private int longest = 0;

    private void breakit(String word, int count) {
        // Ignore when only single character or less
        if (word.length() <= 1) return;
        for (int i = 0; i < word.length(); i++) {
            String s = new StringBuilder(word).deleteCharAt(i).toString();
            if (wordsCount.containsKey(s)) continue;
            if (wordSet.contains(s)) {
                wordsCount.put(s, count + 1);
                longest = Math.max(longest, count + 1);
                breakit(s, count + 1);
            }
        }
    }

    public static void main(String[] args) {
//        String[] words = new String[] {
//            "xbc","pcxbcf","xb","cxbc","pcxbc"
//        };
//        String[] words = new String[] {
//            "a","b","ba","bca","bda","bdca"
//        };
        String[] words = new String[] {
            "a","b","ba","abc","abd","bdca"
        };
//        String[] words = new String[] {
//            "a","ab","ac","bd","abc","abd","abdd"
//        };
        System.out.println(new LongestStringChain().longestStrChain2(words));
        System.out.println(Arrays.toString(words));
    }
}
