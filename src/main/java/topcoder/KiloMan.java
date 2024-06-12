package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class KiloMan {

    public static void main(String[] args) {
//        int[] pattern = {1,3,2,3,3,1,2,2,1};
//        String jumps = "JJSSSJSSJ";
        int[] pattern = {1};
        String jumps = "J";

        System.out.println(new KiloMan().hitsTaken(pattern, jumps));
    }

    public int hitsTaken(int[] pattern, String jumps) {
        int hits = 0;
        for(int i=0; i<pattern.length; i++) {
            int shot = pattern[i];
            char jump = jumps.charAt(i);
            if((shot == 1 || shot == 2) && jump == 'S') {
                hits++;
            } else if(shot > 2 && jump == 'J') {
                hits++;
            }
        }
        return hits;
    }

}
