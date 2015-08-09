package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class WritingWords {

    public static void main(String[] args) {
        String word = "VAMOSGIMNASIA";
        System.out.println(new WritingWords().write(word));
    }


    public int write(String word) {
        String alpha = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int times = 0;
        for(int i=0; i<word.length(); i++) {
            times += alpha.indexOf(word.charAt(i));
        }
        return times;
    }

}
