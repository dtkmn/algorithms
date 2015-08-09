package topcoder;

/**
 * Created by dtkmn on 9/08/2015.
 */
public class InsideOut {

    public static void main(String[] args) {
//        String line = "I ENIL SIHTHSIREBBIG S";
        String line = "RUT OWT SNEH HCNERF EERHTEGDIRTRAP A DNA  SEVODELT";
        System.out.println(new InsideOut().unscramble(line));
    }

    public String unscramble(String line) {
        int mid = line.length()/2;
        StringBuilder sb = new StringBuilder();
        for(int i=mid-1;i>=0; i--) {
            sb.append(line.charAt(i));
        }
        for(int i=line.length()-1;i>=mid; i--) {
            sb.append(line.charAt(i));
        }
        return sb.toString();
    }

}
