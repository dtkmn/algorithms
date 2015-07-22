package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 22/07/2015.
 */
public class Magnets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int groups = 1;
        String first = in.next();

        for(int i=1; i<n; i++) {
            String input = in.next();
            if(!input.equals(first)) {
                groups++;
                first = input;
            }
        }

        System.out.println(groups);

    }

}
