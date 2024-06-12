package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
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

    public int lengthOfLongestSubstring_2023(String s) {
        int[] index = new int[150];
        Arrays.fill(index, -1);
        char[] cs = s.toCharArray();
        int ans = 0;
        int result = 0;
        int start = 0;
        int i = 0;
        while(i < cs.length) {
            if (index[cs[i]] != -1) {
                int oldIndex = index[cs[i]];
                index[cs[i]] = i; // Back to the previous index on same character to start again
                result = Math.max(result, ((i - 1) - start) + 1);
                while (start < oldIndex) {
                    index[cs[start++]] = -1;
                }
                start++; // start = oldIndex + 1;
                ans = i - start + 1;
            } else {
                index[cs[i]] = i;
                ans++;
            }
            i++;
        }
        return Math.max(result, ans);
    }

    public static void main(String[] args) {
        System.out.println(
            new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_2023("abcabcbb"
        ));
        System.out.println(
            new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring_2023("abba"
        ));
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


    }

}
