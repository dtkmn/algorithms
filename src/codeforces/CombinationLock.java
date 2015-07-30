package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 30/07/2015.
 */
public class CombinationLock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = in.next();
        String b = in.next();
        int sum = 0;
        for(int i=0; i<n; i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);
            if(Math.abs(c-d) > 5) {
                // have to go through top and bottom
                int u = Character.getNumericValue(c);
                int v = Character.getNumericValue(d);
                if(u > 5) sum += (10 - u); else sum+= u;
                if(v > 5) sum += (10 - v); else sum+= v;
            } else {
                sum += Math.abs(c-d);
            }

        }
        System.out.println(sum);
    }

}
