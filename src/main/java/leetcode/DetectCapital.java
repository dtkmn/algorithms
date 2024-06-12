package leetcode;

/*
   https://leetcode.com/problems/detect-capital/
 */
public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
    }

    public static boolean detectCapitalUse(String word) {
        char[] c = word.toCharArray();
        if (c.length <= 1) return true;
        boolean firstCapital = c[0] >= 'A' && c[0] <= 'Z';
        boolean secondCapital = c[1] >= 'A' && c[1] <= 'Z';
        if (!firstCapital && secondCapital) return false;
        for (int i = 2; i < c.length; i++) {
            if (firstCapital && secondCapital && c[i] >= 'a' && c[i] <= 'z') return false;
            if (firstCapital && !secondCapital && c[i] >= 'A' && c[i] <= 'Z') return false;
            if (!firstCapital && c[i] >= 'A' && c[i] <= 'Z') return false;
        }
        return true;
    }

}
