package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 5/08/2015.
 */
public class SoftDrinking {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int friends = in.nextInt();
        int bottles = in.nextInt();
        int literPerBottles = in.nextInt();
        int limes = in.nextInt();
        int slicesPerLime = in.nextInt();
        int salt = in.nextInt();
        int drinkForEachToast = in.nextInt();
        int saltForEachToast = in.nextInt();

        int totalDrinks = bottles * literPerBottles;
        int totalLimes = limes * slicesPerLime;

        int toasts = Math.min(Math.min(totalDrinks / drinkForEachToast, totalLimes), salt/saltForEachToast);

        System.out.println(toasts/friends);

    }

}
