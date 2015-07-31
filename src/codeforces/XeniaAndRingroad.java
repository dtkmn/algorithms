package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 31/07/2015.
 */
public class XeniaAndRingroad {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int houses = in.nextInt();
        int tasks = in.nextInt();
        int current = 1;
        long time = 0;
        for(int i=0; i<tasks; i++) {
            int a = in.nextInt();
            if(a >= current) {
                time += (a - current);
            } else {
                time += (houses - current + a);
            }
            current = a;
        }
        System.out.println(time);

    }

}
