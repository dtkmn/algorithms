package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class TheLoveLetterMystery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            String input = in.next();
            int ops = 0;
            for(int m=0,n=input.length()-1; m<n; m++,n--) {
                ops += Math.abs(input.charAt(m) - input.charAt(n));
            }
            System.out.println(ops);
        }
    }

}
