package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 29/07/2015.
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int T = in.nextInt();
        int[] lanes = new int[length];
        for(int i=0; i<length; i++) {
            lanes[i] = in.nextInt();
        }

        for(int j=0; j<T; j++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int min = 3;
            for(int m=a; m<=b; m++) {
                min = Math.min(lanes[m], min);
            }
            System.out.println(min);
        }

    }

}
