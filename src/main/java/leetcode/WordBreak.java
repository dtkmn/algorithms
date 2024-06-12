package leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    private String s;
    private List<String> wordDict;
    private boolean ans;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
//        dfs(s, 0);
        bfs(s);
        return ans;
    }

    private void dfs(String currentString, int count) {
        if (currentString.isEmpty()) {
            ans = true;
            return;
        }
        for (String word: wordDict) {
            if (currentString.indexOf(word) == 0) {
                dfs(currentString.substring(word.length()), count + 1);
            }
        }
    }

    private void bfs(String currentString) {
        Queue<String> queue = new LinkedList<>();
        queue.add(currentString);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (String word: wordDict) {
                    if (str.indexOf(word) == 0) {
                        String s = str.substring(word.length());
                        if (s.isEmpty()) {
                            ans = true;
                            return;
                        }
                        queue.add(s);
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        System.out.println(
            new WordBreak().wordBreak("leetcode", List.of("leet", "code"))
        );
        System.out.println(
            new WordBreak().wordBreak("applepenapple", List.of("apple", "pen"))
        );
        // s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        System.out.println(
            new WordBreak().wordBreak("catsandog", List.of("cats","dog","sand","and","cat"))
        );
    }
}
