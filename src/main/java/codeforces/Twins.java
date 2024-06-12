package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class Twins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] counts = new int[101];
        int total = 0;
        int max = 0;
        for(int i=0; i<n; i++) {
            int input = in.nextInt();
            counts[input]++;
            total += input;
            if(max < input) max = input;
        }

        int requireAmount = total/2;
        int current = 0;
        int coins = 0;
        for(int j=max; j>0; j--) {
            while(counts[j] > 0 && current <= requireAmount) {
                current += j;
                counts[j] = counts[j] - 1;
                coins++;
            }
        }
        System.out.println(coins);

    }

}
