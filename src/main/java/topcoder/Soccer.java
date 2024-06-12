package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class Soccer {

    public static void main(String[] args) {
        int[] wins = {1,4,3,0,0};
        int[] ties = {3,1,5,3,1};
        System.out.println(new Soccer().maxPoints(wins, ties));
    }

    public int maxPoints(int[] wins, int[] ties) {
        int teams = wins.length;
        int max = 0;
        for(int i=0; i<teams; i++) {
            int points = wins[i] * 3 + ties[i] * 1;
            max = Math.max(points, max);
        }
        return max;
    }

}
