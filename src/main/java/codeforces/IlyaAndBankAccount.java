package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 30/07/2015.
 */
public class IlyaAndBankAccount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n >= 0) {
            System.out.println(n);
        } else {
            String s = n+"";
            // last digit
            int a = Integer.valueOf(s.substring(0, s.length() - 1));
            // second last digit
            int b = Integer.valueOf(s.substring(0, s.length()-2) + s.substring(s.length()-1));
            System.out.println(Math.max(a, b));
        }
    }

}
