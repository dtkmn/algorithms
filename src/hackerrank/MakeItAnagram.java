package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 28/07/2015.
 */
public class MakeItAnagram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a1 = in.next();
        String a2 = in.next();
        String b1 = a1;

        for(int i=0; i<a1.length(); i++) {
            char c = a1.charAt(i);
            if(a2.indexOf(c) != -1) {
                b1 = b1.replaceFirst(c+"", "");
                a2 = a2.replaceFirst(c+"", "");
            }
        }

        System.out.println(b1.length() + a2.length());

    }

}
