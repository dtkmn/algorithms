package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 20/08/2015.
 */
public class MinimumDifficulty {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] list = new int[n];
        for(int i=0; i<n; i++) {
            list[i] = in.nextInt();
        }

        int minDiff = Integer.MAX_VALUE;
        int checkPos = 1;
        while(checkPos < n-1) {
            int max = 0;
            for (int j = 1; j < n - 1; j++) {
                if (j == checkPos) {
                    int diff = list[j+1] - list[j-1];
                    max = Math.max(diff, max);
                } else {
                    int diff = list[j+1] - list[j];
                    max = Math.max(diff, max);
                }
            }
            checkPos++;
            minDiff = Math.min(max, minDiff);
        }
        System.out.println(minDiff);

    }

}
