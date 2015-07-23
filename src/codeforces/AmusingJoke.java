package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class AmusingJoke {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputs = in.next() + in.next();
        String piles = in.next();
//        System.out.println(inputs);
//        System.out.println(piles);
        if(inputs.length() != piles.length()) {
            System.out.println("NO");
            return;
        }
        for(int i=0; i< inputs.length(); i++) {
            char c = inputs.charAt(i);
            if(piles.indexOf(c) != -1) {
                piles = piles.replaceFirst(c + "", "");
            }
        }

        if(piles.length() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
