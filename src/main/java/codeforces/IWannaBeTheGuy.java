package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class IWannaBeTheGuy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int levels = in.nextInt();
        boolean[] check = new boolean[levels+1];
        int x = in.nextInt();
        for(int i=0; i<x; i++) {
            check[in.nextInt()] = true;
        }
        int y = in.nextInt();
        for(int i=0; i<y; i++) {
            check[in.nextInt()] = true;
        }
        for(int m=1; m<check.length; m++) {
            if(!check[m]) {
                System.out.println("Oh, my keyboard!");
                return;
            }
        }

        System.out.println("I become the guy.");

    }

}
