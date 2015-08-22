package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 22/08/2015.
 */
public class FlippingGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        int[] gains = new int[n];

        int count1 = 0;
        for(int i=0; i<n; i++) {
            list[i] = in.nextInt();
            if(list[i] == 1) {
                count1++;
                gains[i] = -1;
            } else {
                gains[i] = 1;
            }
        }

        if(n == 1) {
            System.out.println(list[0] == 1?0:1);
            return;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++) {
            for(int j=i; j<n; j++) {
                int sum = 0;
                for(int k=i; k<=j; k++) {
                    sum += gains[k];
                }
                max = Math.max(sum, max);
            }
        }

        System.out.println(count1 + max);

    }

}
