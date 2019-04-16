package leetcode;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("asjrgapa"
//                ));
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "
//                ));
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"
//                ));
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"
//                ));
        System.out.println(
                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"
                ));
        System.out.println(
                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"
                ));
    }


    public int lengthOfLongestSubstring(String s) {
        // The HashMap will be used to store as Key: character, Value: index
        Map<Character, Integer> map = new HashMap<>();
        int front = 0, max = 0, i;
        for (i = front; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int size = i - front;
                if(size > max) max = size;
                if(map.get(c) + 1 > front)
                    front = map.get(c) + 1;
            }
            map.put(c, i);
        }
        int size = i - front;
        if(size > max) max = size;
        return max;
    }

}
