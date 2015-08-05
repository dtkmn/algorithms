package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class CaisaAndSugar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int money = in.nextInt() * 100;
        int max = -1;
        boolean able = false;
        for(int i=0; i<n; i++) {
            int dollar = in.nextInt() * 100;
            int cents = in.nextInt();
            if(money-(dollar+cents) >= 0) able = true;
            max = Math.max(max, (money - (dollar + cents))%100);
        }
        System.out.println(able?max:-1);
    }

}
