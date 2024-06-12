package hackerrank;

import java.util.Scanner;

/**
 * Created by datse on 29/07/2015.
 */
public class SongOfPi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.valueOf(in.nextLine());

        String pi = "31415926535897932384626433833";
        char[] pis = pi.toCharArray();

        for(int i=0; i<T; i++) {
            String input = in.nextLine();
            String[] inputs = input.split(" ");
            boolean pisong = true;
            for(int j=0; j<inputs.length; j++) {
                if(inputs[j].length() != Character.getNumericValue(pis[j])) {
                    pisong = false;
                    break;
                }
            }
            System.out.println(pisong?"It's a pi song.":"It's not a pi song.");
        }

    }

}
