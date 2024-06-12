package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 5/08/2015.
 */
public class CircleLine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] stations = new int[n+1];
        int sum = 0;
        for(int i=1; i<=n; i++) {
            if(i == 1) {
                stations[1] = 0;
            } else {
                sum += in.nextInt();
                stations[i] = sum;
            }
        }

        int tailToFront = in.nextInt();

//        System.out.println(Arrays.toString(stations));

        int firstStation = in.nextInt();
        int secondStation = in.nextInt();

        int firstDistance = Math.abs(stations[firstStation] - stations[secondStation]);

        int secondDistance = 0;
        if(secondStation > firstStation) {
            int distanceToTail = Math.abs(stations[n]-stations[secondStation]);
            int frontDistance = Math.abs(stations[1]-stations[firstStation]);
            secondDistance = distanceToTail + frontDistance + tailToFront;
        } else {
            int distanceToTail = Math.abs(stations[n]-stations[firstStation]);
            int frontDistance = Math.abs(stations[1]-stations[secondStation]);
            secondDistance = distanceToTail + frontDistance + tailToFront;
        }

        System.out.println(Math.min(firstDistance, secondDistance));

    }

}
