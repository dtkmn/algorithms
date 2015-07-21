package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class InsomniaCure {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int l = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int total = in.nextInt();

        if(k == 1 || l == 1 || m == 1 || n == 1) {
            System.out.println(total);
            return;
        }

        int killDragon = 0;
        for(int i=1; i<=total; i++) {
            if(i%k==0 || i%l==0 || i%m==0 || i%n==0) {
                killDragon++;
            }
        }
        System.out.println(killDragon);

    }

}
