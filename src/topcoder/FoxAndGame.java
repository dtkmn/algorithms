package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class FoxAndGame {

    public static void main(String[] args) {
        String[] result = {"ooo",
                "ooo"};
        System.out.println(new FoxAndGame().countStars(result));
    }

    public int countStars(String[] result) {
        int count = 0;
        for(int i=0; i<result.length; i++) {
            String input = result[i];
            for(int j=0; j<input.length(); j++) {
                if(input.charAt(j) == 'o') {
                    count++;
                }
            }
        }
        return count;
    }

}
