package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 23/08/2015.
 */
public class SoldierAndBadges {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] badges = new int[n];
        for(int i=0; i<n; i++) {
            badges[i] = in.nextInt();
        }
        Arrays.sort(badges);
        int currentLevel = badges[0];
        int coins = 0;
        for(int i=1; i<n; i++) {
            if(badges[i] == currentLevel) {
                coins++;
                currentLevel++;
            } else if(badges[i] < currentLevel) {
                currentLevel++;
                coins += (currentLevel - badges[i]);
            } else {
                currentLevel = badges[i];
            }
        }

        System.out.println(coins);
    }

}
