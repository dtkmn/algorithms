package leetcode;

import java.util.Arrays;
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
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"
//                ));
//        System.out.println(
//                new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring3("dvdf"));

        System.out.println(
            new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_update("tmmzuxt"
            ));
        System.out.println(
            new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_update("       "
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

    public int lengthOfLongestSubstring_update(String s) {
        int[] charIndex = new int[128];
        Arrays.fill(charIndex, -1);

        int start = 0, longest = 0;
        char[] charArray = s.toCharArray();

        for (int end = 0; end < charArray.length; end++) {
            // When the character already existed within the map
            int index = charIndex[charArray[end]];
            if (index >= start) {
                // Reset start last index + 1
                start = index + 1;
                // Add only current character to the map
                charIndex[charArray[end]] = end;
            } else {
                // Add current character with its index to the map
                charIndex[charArray[end]] = end;
                // Get the length for current non-duplicated string
                int length = end - start + 1;
                // Compare and replace with longer value
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

}
