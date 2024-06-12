package hackerrank;

import java.util.Scanner;

/**
 * Created by dtkmn on 9/07/2015.
 * Power of XOR
 */
public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int a = 0;
        for(int i=0; i<N; i++) {
            int b = in.nextInt();
            a ^= b;
            System.out.println("a: " + a);
        }
        System.out.println(a);
    }


}
