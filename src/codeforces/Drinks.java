package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 6/08/2015.
 */
public class Drinks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double sum = 0.0;
        for(int i=0; i<n; i++) {
            sum += in.nextInt();
        }
        System.out.println(sum/n);
    }

}
