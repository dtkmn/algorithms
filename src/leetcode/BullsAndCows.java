package leetcode;


/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {

    public static String getHint(String secret, String guess) {

        int[] s = new int[10];
        int[] g = new int[10];

        int a = 0, b = 0;

        char[] sca = secret.toCharArray();
        char[] gca = guess.toCharArray();

        for (int i = 0; i < sca.length; i++) {
            int sc = Character.getNumericValue(sca[i]);
            int gc = Character.getNumericValue(gca[i]);
            if (sc == gc) a++;
            else {
                s[sc]++;
                g[gc]++;
            }
        }


        for (int j = 0; j < s.length; j++) {
            if (s[j] > 0 && g[j] > 0) {
                b += Math.min(s[j], g[j]);
            }
        }

        return a + "A" + b + "B";

    }

    public static void main(String[] args) {
        System.out.println(
            getHint("1807", "7810")
        );
    }

}
