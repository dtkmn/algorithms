package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 15/08/2015.
 */
public class TheNumberOfPositions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int infront = in.nextInt();
        int nomoreback = in.nextInt();
        int count = 0;
        for(int i=infront+1; i<=n; i++) {
            if(n-i <= nomoreback) count++;
        }
        System.out.println(count);
    }

    // 1 2 3 4 5
    // a = 2, b = 3
    // 1 2 3 4 5 6 7 8 9
    // a=4, b=3
}
