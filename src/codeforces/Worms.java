package codeforces;

import java.util.Arrays;
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
        System.out.println(Arrays.toString(piles));

        int worms = in.nextInt();
        for(int i=1; i<=worms; i++) {
            int label = in.nextInt();

            System.out.println(binarySearch(piles, label));
//            for(int j=1; j<=numPiles; j++) {
//                if(label <= piles[j]) {
//                    System.out.println(j);
//                    break;
//                }
//            }

        }
    }

    static int binarySearch(int[] piles, int value) {
        int low = 1, high = piles.length-1;
        while(low != high) {
            int middle = (low + high)/2;
            if (value > piles[middle]) low = middle;
            else if (value < piles[middle]) high = middle;
            else return middle;
        }
        return low;
    }

}
