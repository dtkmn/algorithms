package leetcode;


/**
 * <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">...</a>
 *
 */
public class SortVowelsInAString {

    public static String sortVowels(String s) {
        boolean[] replace = new boolean[s.length()];
        char[] cs = s.toCharArray();
        int[] count = new int[10];
        String support = "AEIOUaeiou";
        for (int i = 0; i < cs.length; i++) {
            int foundIndex = support.indexOf(cs[i]);
            if (foundIndex >= 0) {
                replace[i] = true;
                count[foundIndex]++;
            }
        }
        int countPos = 0;
        for (int j = 0; j < replace.length; j++) {
            if (replace[j]) {
                while (countPos < 10) {
                    if (count[countPos] > 0) {
                        cs[j] = support.charAt(countPos);
                        count[countPos]--;
                        break;
                    } else countPos++;
                }
            }
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(
                sortVowels("lEetcOde")
        );
    }
}
