package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class WordCapitalization {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(Character.toUpperCase(input.charAt(0)) + input.substring(1));
    }

}
