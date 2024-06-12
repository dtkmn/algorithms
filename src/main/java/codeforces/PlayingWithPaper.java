package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class PlayingWithPaper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long chips = 0;
        while(a > 0 && b > 0) {
            if (a > b) {
                chips += a / b;
                a = a % b;
            } else {
                chips += (b / a);
                b = b % a;
            }
        }
        System.out.println(chips);

    }

}
