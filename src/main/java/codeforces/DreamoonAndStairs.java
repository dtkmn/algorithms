package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class DreamoonAndStairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int steps = in.nextInt();
        int m = in.nextInt();
        if(m > steps) {
            System.out.println(-1);
        } else if(m == steps) {
            System.out.println(m);
        } else {
            int min = steps%2==0?steps/2:steps/2+1;
            int max = steps;
            for(int i=min; i<=max; i++) {
                if(i % m == 0) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }

}
