package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 25/07/2015.
 */
public class Pangram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();

        if(n < 26) {
            System.out.println("NO");
            return;
        }

        String letters = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<n; i++) {
            char c = input.charAt(i);
            int pos = letters.indexOf(Character.toLowerCase(c));
            if(pos != -1) {
                letters = letters.replaceFirst(Character.toLowerCase(c)+"", "");
            }
        }

        System.out.println(letters.length()==0?"YES":"NO");




    }

}
