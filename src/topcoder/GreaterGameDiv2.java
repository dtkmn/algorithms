package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class GreaterGameDiv2 {

    public static void main(String[] args) {
        int[] snuke = {1,3,5,7,9};
        int[] sothe = {2,4,6,8,10};
        System.out.println(new GreaterGameDiv2().calc(snuke, sothe));
    }


    public int calc(int[] snuke, int[] sothe) {
        int wins = 0;
        for(int i=0; i<snuke.length; i++) {
            if(snuke[i] > sothe[i]) wins++;
        }
        return wins;
    }

}
