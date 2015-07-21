package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class VasyaAndSocks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int day = 0;
        while(n > 0) {
            day++;
            n--;
            if(day%m==0)n++;
        }

        System.out.println(day);
    }

}
