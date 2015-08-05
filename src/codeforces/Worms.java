package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class Worms {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPiles = in.nextInt();
        int sum = 0;
        int[] piles = new int[numPiles+1];
        for(int i=1; i<=numPiles; i++) {
            sum += in.nextInt();
            piles[i] = sum;
        }

        int worms = in.nextInt();
        for(int i=1; i<=worms; i++) {
            int label = in.nextInt();
            System.out.println(binarySearch(piles, label));
        }
    }

    public static int binarySearch(int[] piles, int value) {
        int low = 1, high = piles.length-1;
        // { 1, 5, 13, 24, 35 }
        int middle = low;
        while(Math.abs(high-low) > 1) {
            middle = (low+high)%2==0 ? (low+high)/2 : 1+(low+high)/2;
            if (value > piles[middle]) low = middle + 1;
            else if (value <= piles[middle]) high = middle;
            else return middle;
        }
        if(piles[low] >= value) return low;
        else return high;
    }

}
