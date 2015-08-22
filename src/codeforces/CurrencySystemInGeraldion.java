package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class CurrencySystemInGeraldion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] notes = new int[n];
        for(int i=0; i<n; i++) {
            notes[i] = in.nextInt();
            if (notes[i] == 1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

}
