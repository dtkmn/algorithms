package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class SoldierAndBananas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cost = in.nextInt();
        int money = in.nextInt();
        int want = in.nextInt();

        int count = 1;
        while(want > 0) {
            money -= (count * cost);
            want--; count++;
//            System.out.println("money: " + money +
//                    " cost: " + (count * cost) + " want: " + want);
        }
        System.out.println(money>=0?0:Math.abs(money));

    }

}
