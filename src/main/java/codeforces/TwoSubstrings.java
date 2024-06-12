package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 24/08/2015.
 */
public class TwoSubstrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();

        String saved = input;
        boolean testA = false;
        if(saved.contains("AB")){
            saved = saved.substring(saved.indexOf("AB") + 2);
            if(saved.contains("BA")) {
                testA = true;
            }
        }

        boolean testB = false;
        saved = input;
        if(saved.contains("BA")){
            saved = saved.substring(saved.indexOf("BA")+2);
            if(saved.contains("AB")) {
                testB = true;
            }
        }

        System.out.println(testA || testB?"YES":"NO");

    }

}
