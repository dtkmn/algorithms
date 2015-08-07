package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 7/08/2015.
 */
public class Army {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRanks = in.nextInt();
        int[] ranks = new int[numRanks+1];
        for(int i=2; i<=numRanks; i++) {
            ranks[i] = in.nextInt();
        }

        int startRank = in.nextInt();
        int destRank = in.nextInt();

        int years = 0;
        for(int j=startRank+1; j<=destRank; j++) {
            years += ranks[j];
        }

        System.out.println(years);
    }

}
