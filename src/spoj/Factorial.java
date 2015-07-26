package spoj;

import java.util.Scanner;

/**
 * http://www.spoj.com/problems/FCTRL/
 *
 * http://www.purplemath.com/modules/factzero.htm
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i<N; i++) {
            int x = in.nextInt();
            int sum = 0;
            while(x > 0) {
                int d = x/5;
                sum += d;
                x = d;
            }
            System.out.println(sum);

        }

    }

}
