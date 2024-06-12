package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 2/08/2015.
 */
public class ChewbaсcaAndNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String output = "";
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            int ci = Character.getNumericValue(c);
            if(ci >= 5) {
                if(ci == 9 && i == 0) {
                    output += c;
                } else {
                    output += (9 - ci);
                }
            } else {
                output += c;
            }
        }
        System.out.println(output);
    }

}
