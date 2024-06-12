package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class Rewards {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cups = 0, medals = 0;
        for(int i=0; i<3; i++) {
            cups += in.nextInt();
        }
        for(int i=0; i<3; i++) {
            medals += in.nextInt();
        }
        int shelfs = in.nextInt();

        int require = 0;
        if(cups%5==0) {
            require += cups/5;
        } else {
            require += cups/5 + 1;
        }
        if(medals%10==0) {
            require += medals/10;
        } else {
            require += medals/10 + 1;
        }
        System.out.println(shelfs>=require?"YES":"NO");

    }

}
