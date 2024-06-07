package leetcode;


/**
 *  <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/">3042. Count Prefix and Suffix Pairs I</a>
 */

public class CountPrefixAndSuffixPairsI {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String key = words[j];
                if (key.startsWith(word) && key.endsWith(word)) {
                    count++;
                }
            }
        }
        return count;
    }

}
