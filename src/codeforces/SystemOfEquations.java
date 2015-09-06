package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 6/09/2015.
 */
public class SystemOfEquations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int count = 0;
        for(int a=0; a<=Math.sqrt(1000); a++) {
            for(int b=0; b<=Math.sqrt(1000); b++) {
                if(Math.pow(a, 2) + b == n && a + Math.pow(b, 2) == m)
                    count++;
            }
        }
        System.out.println(count);

    }

}
