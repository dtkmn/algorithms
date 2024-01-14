package leetcode;


/**
 * <a href="https://leetcode.com/problems/ransom-note/">...</a>
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count1 = new int[26];
        for (char c: ransomNote.toCharArray()) {
            count1[c - 'a']++;
        }
         int[] count2 = new int[26];
        for (char c: magazine.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > count2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
