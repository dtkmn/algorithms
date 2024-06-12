package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class Translation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        if(first.length() != second.length()) {
            System.out.println("NO");
            return;
        }

        for(int i=0; i<first.length(); i++) {
            if(first.charAt(i) != second.charAt(first.length()-1-i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

}
