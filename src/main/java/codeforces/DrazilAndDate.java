package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class DrazilAndDate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int s = in.nextInt();

        int minStep = Math.abs(a) + Math.abs(b);
        if(s < minStep) {
            System.out.println("No");
        } else {
            if((s - minStep) % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }

}
