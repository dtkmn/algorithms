package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class AandBandCompilationErrors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum1=0, sum2=0, sum3=0;
        for(int i=0; i<n; i++) {
            sum1 += in.nextInt();
        }
        for(int i=0; i<n-1; i++) {
            sum2 += in.nextInt();
        }
        System.out.println(sum1-sum2);
        for(int i=0; i<n-2; i++) {
            sum3 += in.nextInt();
        }
        System.out.println(sum2-sum3);
    }

}
