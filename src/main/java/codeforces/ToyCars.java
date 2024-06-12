package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 4/08/2015.
 */
public class ToyCars {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n+1];
        int count = 0;
        for(int i=1; i<=n; i++) {
            boolean good = true;
            for(int j=1; j<=n; j++) {
                int input = in.nextInt();
                if(input == 1) {
                    list[i]++;
                    good = false;
                } else if(input == 3) {
                    list[i]++;
                    good = false;
                }
            }
            if(good) count++;
        }

        System.out.println(count);
        for(int i=1; i<=n; i++) {
            if(list[i] == 0) System.out.print(i + " ");
        }
    }

}
