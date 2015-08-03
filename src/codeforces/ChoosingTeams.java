package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class ChoosingTeams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int times = in.nextInt();
        int count = 0;
        for(int i=0; i<N; i++) {
            if((in.nextInt()+times) <=5) {
                count++;
            }
        }
        System.out.println(count/3);
    }

}
