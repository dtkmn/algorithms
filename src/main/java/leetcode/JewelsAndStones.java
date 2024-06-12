package leetcode;


/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    private static int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.indexOf(c) >= 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + numJewelsInStones("z", "ZZ"));
    }

}
