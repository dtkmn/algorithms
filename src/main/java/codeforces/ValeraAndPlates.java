package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class ValeraAndPlates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        int cleanBowls = in.nextInt();
        int cleanPlates = in.nextInt();
        int wash = 0;
        for(int i=0; i<days; i++) {
            int dish = in.nextInt();
            if(dish == 1) {
                if(cleanBowls > 0) {
                    cleanBowls--;
                } else {
                    wash++;
                }
            } else if(dish == 2) {
                if(cleanPlates > 0) {
                    cleanPlates--;
                } else if(cleanBowls > 0) {
                    cleanBowls--;
                } else {
                    wash++;
                }
            }
        }
        System.out.println(wash);

    }

}
