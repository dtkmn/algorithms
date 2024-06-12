package leetcode;


/**
 *  <a href="https://leetcode.com/problems/remove-vowels-from-a-string/">...</a>
 */

public class RemoveVowelsFromAString {
    /**
     *
     * Time Complexity: O(n) length of input String s
     * Space Complexity: Output String without vowels
     *
     * @param s
     * @return
     */
    public String removeVowels(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
    }

}
