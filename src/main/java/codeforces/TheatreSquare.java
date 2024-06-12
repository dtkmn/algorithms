package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class TheatreSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt();
        double m = in.nextInt();
        double a = in.nextInt();

        System.out.println((long)(Math.ceil(n/a) * Math.ceil(m/a)));

    }

}
