package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class CinemaLine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num25 = 0, num50 = 0;
        for(int i=0; i<n; i++) {
            int t = in.nextInt();
            if(t == 25) {
                num25++;
            } else if(t == 50) {
                if (num25 > 0) {
                    num25--;
                    num50++;
                } else {
                    System.out.println("NO");
                    return;
                }
            } else if(t == 100) {
                if((num25 > 0 && num50 > 0)) {
                    num25--; num50--;
                } else if(num25 >= 3) {
                    num25 -= 3;
                } else {
                    System.out.println("NO");
                    return;
                }

            }
        }
        System.out.println("YES");
    }

}
