package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class EpicGame {

    static int gcd(int a, int b) {
        if(a % b == 0) return b;
        if(b % a == 0) return a;
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int round = 0;
        while(n > 0) {
            if(round%2 == 0) {
                n -= gcd(a, n);
            } else {
                n -= gcd(b, n);
            }
            round++;
        }
        System.out.println(round%2==0?"1":"0");
    }

}
