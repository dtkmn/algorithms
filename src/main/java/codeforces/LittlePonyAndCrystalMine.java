package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class LittlePonyAndCrystalMine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int odd = in.nextInt();

        for(int i=1; i<=odd; i+=2) {
            int numStar = (odd-i)/2;
            for(int j=0; j<numStar; j++) {
                System.out.print("*");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("D");
            }
            for(int j=0; j<numStar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=odd-2; i>=1; i-=2) {
            int numStar = (odd-i)/2;
            for(int j=0; j<numStar; j++) {
                System.out.print("*");
            }
            for(int j=1; j<=i; j++) {
                System.out.print("D");
            }
            for(int j=0; j<numStar; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
