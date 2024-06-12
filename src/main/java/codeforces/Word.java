package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class Word {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int upper = 0;
        int lower = 0;
        for(int i=0; i<input.length(); i++) {
            if(Character.isLowerCase(input.charAt(i))) {
                lower++;
            } else {
                upper++;
            }
        }
        if(lower >= upper) {
            System.out.println(input.toLowerCase());
        } else {
            System.out.println(input.toUpperCase());
        }
    }

}
