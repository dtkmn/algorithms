package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 7/07/2015.
 * https://www.hackerrank.com/challenges/truck-tour
 * Hints:
 * Consider the amount of fuel you have in your tank as a function of the amount of stations you have passed (the integral of the change in fuel {gained - used} per station results in the amount of fuel for every station, the fundamental theorem of calculus). Now: this function has to be positive for every station because you cannot ever have negative fuel in your tank. This only happens whenever you start at a global minimum of this function. You are essentially shifting the function vertically, setting it to zero at your starting point and if this is the lowest point then all other points will be positive.
 */
public class TruckTour {

    // INTEGRATION AND GLOBAL MINIMUM
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int minPatrol = -1;
        int location = -1;
        int p = 0;

        for(int i=0; i<N; i++) {
            int patrol = in.nextInt();
            int distance = in.nextInt();
//            System.out.println(p);
            if(p < minPatrol) {
                minPatrol = p;
                location = i;
            }
            p = p + patrol - distance;
//            System.out.println("gas left : " + process + " at " + i + " : " + p);

        }

        System.out.println(location);


    }

}
