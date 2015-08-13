package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 13/08/2015.
 */
public class LinelandMail {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cities = new int[n];
        for(int i=0; i<n; i++) {
            cities[i] = in.nextInt();
        }

        for(int i=0; i<n; i++) {
            int min=0, max=0;
            if(i==0 && i+1<n) {
                min = Math.abs(cities[i] - cities[i + 1]);
                max = Math.abs(cities[i] - cities[n - 1]);
            } else if(i==n-1) {
                min = Math.abs(cities[i] - cities[i - 1]);
                max = Math.abs(cities[0] - cities[n - 1]);
            } else {
                min = Math.min(Math.abs(cities[i] - cities[i+1]) ,
                    Math.abs(cities[i] - cities[i-1]));
                max = Math.max(Math.abs(cities[i] - cities[n - 1]),
                        Math.abs(cities[i] - cities[0]));
            }
            System.out.println(min + " " + max);
        }

    }

}
