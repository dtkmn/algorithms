package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 29/07/2015.
 */
public class MaximizingXOR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int max = 0;

        for(int i=Math.min(a, b); i<=Math.max(a, b); i++) {
            for(int j=Math.min(a, b); j<=Math.max(a, b); j++) {
                max = Math.max(max, i^j);
            }
        }

        System.out.println(max);


    }

}
