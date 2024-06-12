package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class Expression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int max = 0;
        max = Math.max(max, a+b*c);
        max = Math.max(max, a*(b+c));
        max = Math.max(max, a*b+c);
        max = Math.max(max, a*b*c);
        max = Math.max(max, (a+b)*c);
        max = Math.max(max, a+b+c);

        System.out.println(max);
    }

}
