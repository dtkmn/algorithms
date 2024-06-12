package leetcode;


/**
 * <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">...</a>
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] mappings = new int[26];
        int count = 0;
        for (char c: chars.toCharArray()) mappings[c-'a']++;
        for (String word: words) {
            int[] localMap = new int[26];
            for (char c: word.toCharArray()) localMap[c-'a']++;
            for(int i = 0; i < 26; i++) {
                if (localMap[i] > mappings[i]) break;
                if (i == 25) count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
            new FindWordsThatCanBeFormedByCharacters().countCharacters(new String[] {
                    "cat","bt","hat","tree"
                }, "atach"
            )
        );
    }

}
