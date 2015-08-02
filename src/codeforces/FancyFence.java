package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class FancyFence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int angle = in.nextInt();
            // 180*(n-2)/n
            if(360%(180-angle) == 0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

}
