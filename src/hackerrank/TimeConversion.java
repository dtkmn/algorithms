package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 29/07/2015.
 */
public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        if(input.endsWith("AM")) {
            String[] times = input.split(":");
            int hh = Integer.valueOf(times[0]);

            System.out.println((hh<10?"0"+hh:(hh==12?"00":hh)) + input.substring(2, input.length()-2));

        } else if(input.endsWith("PM")) {
            String[] times = input.split(":");
            System.out.println((Integer.valueOf(times[0])==12?"12":(Integer.valueOf(times[0])+12))
                    + input.substring(2, input.length()-2));
        }

    }

}
