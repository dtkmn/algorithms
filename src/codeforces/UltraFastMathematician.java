package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class UltraFastMathematician {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        for(int i=0; i<first.length(); i++) {
            System.out.print(first.charAt(i)^second.charAt(i));
        }
    }

}
