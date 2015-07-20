package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class Team {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(in.nextInt() + in.nextInt() + in.nextInt() >= 2) {
                count++;
            }
        }
        System.out.println(count);
    }

}
