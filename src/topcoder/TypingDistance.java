package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class TypingDistance {

    public static void main(String[] args) {
//        String keyboard = "qwertyuiop";
//        String word = "potter";
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        String word = "topcodersingleroundmatchgoodluckhavefun";
        System.out.println(new TypingDistance().minDistance(keyboard, word));
    }

    public int minDistance(String keyboard, String word) {
        int currentPos = keyboard.indexOf(word.charAt(0));
        int distance = 0;
        for(int i=1; i<word.length(); i++) {
            int pos = keyboard.indexOf(word.charAt(i));
            distance += Math.abs(currentPos-pos);
            currentPos = pos;
        }
        return distance;
    }

}
