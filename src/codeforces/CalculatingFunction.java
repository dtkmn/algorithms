package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class CalculatingFunction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if(n%2 == 0) {
            System.out.println(n/2);
        } else {
            // - (n + 1) / 2
            System.out.println((n+1)/2*-1);
        }
    }

}
