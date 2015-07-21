package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class Presents {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] result = new int[n+1];
        for(int i=1; i<=n; i++) {
            result[in.nextInt()] = i;
        }

        for(int j=1; j<=n; j++) {
            System.out.print(result[j] + " ");
        }
    }

}
