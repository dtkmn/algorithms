package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class Dragons {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int strength = in.nextInt();
        int numDragon = in.nextInt();
        int[] dragonStregth = new int[numDragon];
        int[] bonus = new int[numDragon];

        for(int i=0; i<numDragon; i++) {
            dragonStregth[i] = in.nextInt();
            bonus[i] = in.nextInt();
        }

        for(int j=0; j<numDragon; j++) {
            for(int k=0; k<numDragon; k++) {
                if(j != k && dragonStregth[j] <= dragonStregth[k]) {
                    int temp = dragonStregth[j];
                    dragonStregth[j] = dragonStregth[k];
                    dragonStregth[k] = temp;
                    int temp2 = bonus[j];
                    bonus[j] = bonus[k];
                    bonus[k] = temp2;
                }
            }
        }

        for(int l=0; l<numDragon; l++) {
            if(dragonStregth[l] >= strength) {
                System.out.println("NO");
                return;
            } else {
                strength = strength + bonus[l];
            }
        }

        System.out.println("YES");


    }

}
