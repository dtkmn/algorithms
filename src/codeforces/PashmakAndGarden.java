package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class PashmakAndGarden {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        if(x1 != x2 && y1 != y2) {
            if(Math.abs(x1-x2) != Math.abs(y1-y2)) {
                System.out.println(-1);
                return;
            }
            if(y1 > y2) {
                System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
                return;
            } else {
                System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
                return;
            }
        } else if(x1 == x2) {
            int l = Math.abs(y2 - y1);
            System.out.println((x1+l) + " " + y1 + " " + (x2+l) + " " + y2);
            return;
        } else if(y1 == y2) {
            int l = Math.abs(x2 - x1);
            System.out.println(x1 + " " + (y1+l) + " " + x2 + " " + (y2+l));
            return;
        }

        System.out.println(-1);

    }

}
