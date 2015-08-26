package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 26/08/2015.
 */
public class BersuBall {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int boyCount = in.nextInt();
        int[] boys = new int[boyCount];
        for(int i=0; i<boyCount; i++) {
            boys[i] = in.nextInt();
        }

        int girlCount = in.nextInt();
        int[] girls = new int[girlCount];
        for(int i=0; i<girlCount; i++) {
            girls[i] = in.nextInt();
        }

        Arrays.sort(boys);
        Arrays.sort(girls);

        int result = 0, girlpos = 0;
        for(int i=0; i<boyCount; i++) {
            for(int j=girlpos; j<girlCount; j++) {
                if(Math.abs(boys[i] - girls[j]) <= 1) {
                    result++;
                    girlpos = j+1;
                    break;
                }
            }
        }

        System.out.println(result);

    }

}
