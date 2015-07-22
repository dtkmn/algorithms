package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 22/07/2015.
 */
public class ArrivalOfTheGeneral {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int max = -1, min = 100;
        int maxPos = -1, minPos = -1;
        for(int i=0; i<N; i++) {
            int input = in.nextInt();
            if(input > max) {
                max = input;
                maxPos = i;
            }

            if(input <= min) {
                min = input;
                minPos = i;
            }
        }
        int steps = Math.abs(maxPos - 0) + Math.abs((N - 1)-minPos);
        if(maxPos > minPos) steps--;
        System.out.println(steps);

    }

}
