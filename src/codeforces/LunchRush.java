package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 13/08/2015.
 */
public class LunchRush {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfRestaurants = in.nextInt();
        int timeFromCoach = in.nextInt();
        int result = Integer.MIN_VALUE;
        for(int i=0; i<numberOfRestaurants; i++) {
            int units = in.nextInt();
            int timeRequired = in.nextInt();
            int joys = 0;
            if(timeFromCoach < timeRequired) {
                joys = units - (timeRequired - timeFromCoach);
            } else {
                joys = units;
            }
            result = Math.max(result, joys);
        }
        System.out.println(result);
    }

}
