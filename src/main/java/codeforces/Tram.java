package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class Tram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0, current = 0;
        for(int i=0; i<n; i++) {
            current -= in.nextInt();
            current += in.nextInt();
            if(current > max) max = current;
        }
        System.out.println(max);
    }

}
