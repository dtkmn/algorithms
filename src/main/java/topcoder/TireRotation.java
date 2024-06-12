package topcoder;

/**
 * Created by datse on 10/08/2015.
 * Scores: 219.xx points here
 */
public class TireRotation {

    public static void main(String[] args) {
//        String initial = "ABCD";
//        String current = "DCAB";
        String initial = "ABCD";
        String current = "ABDC";
//        String initial = "ZAXN";
//        String current = "XNAZ";
        System.out.println(new TireRotation().getCycle(initial, current));
    }

    public int getCycle(String initial, String current) {
//        1 ---------> 3
//        2 ---------> 4
//        3 ---------> 2
//        4 ---------> 1
        int phase = 1;
        if(initial.equals(current)) {
            return phase;
        }
        while(true) {
            initial = toNextPhase(initial);
            phase++;
            if(initial.equals(current)) {
                return phase;
            }
            if(phase > 5) return -1;
        }
    }

    String toNextPhase(String input) {
        return new String("" + input.charAt(3) + input.charAt(2) + input.charAt(0) + input.charAt(1));
    }

}
