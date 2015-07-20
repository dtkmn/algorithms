package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class WayTooLongWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; i++) {
            String input = in.next();
            if(input.length() <= 10) {
                System.out.println(input);
            } else {
                System.out.println(input.charAt(0) + "" + (input.length()-2) + "" + input.charAt(input.length()-1));
            }

        }
    }

}
