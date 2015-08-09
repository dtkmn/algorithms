package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class RosePetals {

    public static void main(String[] args) {
//        int[] dice = {1, 2, 3, 2, 1};
        int[] dice = {3, 3, 3, 3, 3};
        System.out.println(new RosePetals().getScore(dice));
    }

    public int getScore(int[] dice) {
        int[] petals = {0,0,0,2,0,4,0};
        int score = 0;
        for(int i=0; i<dice.length; i++) {
            score += petals[dice[i]];
        }
        return score;
    }

}
