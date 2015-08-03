package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class CandyBags {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n*n/2; i++) {
            System.out.println((i+1) + " " + (n*n-i));
        }
    }

}
