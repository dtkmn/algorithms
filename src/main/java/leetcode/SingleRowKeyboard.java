package leetcode;


/**
 * https://leetcode.com/problems/single-row-keyboard/
 */
public class SingleRowKeyboard {

    public static int calculateTime(String keyboard, String word) {
        int count = 0;
        int pos = 0;
        for (int i = 0; i < word.length(); i++) {
            int foundPos = keyboard.indexOf(word.charAt(i));
            count += Math.abs(foundPos - pos);
            pos = foundPos;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
        System.out.println("Result: " + calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }

}
