package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class PetyaAndStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        if(first.equalsIgnoreCase(second)) {
            System.out.println(0);
            return;
        }

        int result = first.compareToIgnoreCase(second);
        if(result < 0) {
            System.out.println(-1);
        } else if(result == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

    }

}
