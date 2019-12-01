package leetcode;


import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordsResult = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            int c = freqWithSmallestChar_noTreeMap(words[j]);
            wordsResult[j] = c;
        }
        Arrays.sort(wordsResult);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int fromQuery = freqWithSmallestChar_noTreeMap(q);
            // Using binary search here?
            int pos = binarySearch(fromQuery, wordsResult, 0, wordsResult.length-1);
            result[i] = wordsResult.length - pos;
        }
        return result;
    }

    public static int binarySearch(int check, int[] input, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check >= input[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }


    public static int freqWithSmallestChar(String input) {
        char[] chars = input.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int m = 0; m < chars.length; m++) {
            if (map.containsKey(chars[m])) {
                map.put(chars[m], map.get(chars[m]) + 1);
            } else map.put(chars[m], 1);
        }
        Character key = map.firstKey();
        return map.get(key);
    }

    // No TreeMap version, should be faster !?
    public static int freqWithSmallestChar_noTreeMap(String input) {
        char[] chars = input.toCharArray();
        char min = '{';
        int[] count26 = new int[26];
        for (int m = 0; m < chars.length; m++) {
//            count26[chars[m] - 97]++;
            if (chars[m] <= min) {
              count26[chars[m] - 97]++;
              min = chars[m];
            }
        }
        return count26[min - 97];
    }

    public static void main(String[] args) {
//        System.out.println(
//            Arrays.toString(
//                numSmallerByFrequency(
//                    new String[]{"cbd"},
//                    new String[]{"zaaaz"})
//            )
//        );
//        System.out.println(
//            Arrays.toString(
//                numSmallerByFrequency(
//                    new String[]{"bbb","cc"},
//                    new String[]{"a","aa","aaa","aaaa"})
//            )
//        );
//        ["bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"]
//        ["aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"]
      // expected
      // [6,1,1,2,3,3,3,1,3,2]
//        System.out.println(
//            Arrays.toString(
//                numSmallerByFrequency(
//                    new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"},
//                    new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"})
//            )
//        );
//["aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"]
//["b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa"]
      // [6,5,0,6,11,11,11,8,11,0,6,6]
      System.out.println(
          Arrays.toString(
              numSmallerByFrequency(
                  new String[]{"aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"},
                  new String[]{"b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa"})
          )
      );
    }

}
