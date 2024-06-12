package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class InitialBet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for(int i=0; i<5; i++) {
            sum += in.nextInt();
        }

        if(sum > 0 && sum % 5 == 0) {
            System.out.println(sum/5);
        } else {
            System.out.println(-1);
        }
    }

}
