package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 5/08/2015.
 */
public class Laptops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] laptops = new int[n+1];
        for(int i=0; i<n; i++) {
            int price = in.nextInt();
            int quality = in.nextInt();
            laptops[price] = Math.max(laptops[price], quality);
        }
        for(int i=1; i<=n-1; i++) {
            if(laptops[i] > laptops[i+1]) {
                System.out.println("Happy Alex");
                return;
            }
        }
        System.out.println("Poor Alex");
    }

}
