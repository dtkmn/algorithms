package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 19/08/2015.
 */
public class NewYearTransportation {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int dest = in.nextInt();
        int current = 1;
        for(int i=1; i<n; i++) {
            int portal = in.nextInt();
            if(i == current) {
                current += portal;
                if(current == dest) {
                    System.out.println("YES");
                    return;
                }
            }
            if(current > dest) break;
        }
        System.out.println("NO");

    }

}
