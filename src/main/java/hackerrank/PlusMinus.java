package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 */
public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int countp = 0, countn = 0, countz = 0;
        for(int i=0; i<N; i++) {
            int x = in.nextInt();
            if(x > 0) countp++;
            else if(x < 0) countn++;
            else countz++;
        }
        System.out.printf("%.3f\n", countp*1.0/N);
        System.out.printf("%.3f\n", countn * 1.0 / N);
        System.out.printf("%.3f\n", countz*1.0/N);
    }

}
