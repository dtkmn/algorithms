package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/08/2015.
 */
public class VanyaAndTable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int i=0; i<n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            sum += (Math.abs(x1-x2)+1) * (Math.abs(y1-y2)+1);
        }
        System.out.println(sum);

    }

}
