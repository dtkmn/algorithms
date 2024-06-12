package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 4/08/2015.
 */
public class ValeraAndAntiqueItems {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfSeller = in.nextInt();
        int money = in.nextInt();
        String finalSellers = "";
        int count = 0;
        for(int i=1; i<=numberOfSeller; i++) {
            int numberOfItems = in.nextInt();
            boolean deal = false;
            for(int j=0; j<numberOfItems; j++) {
                int price = in.nextInt();
                if(money > price) {
                    deal = true;
                }
            }
            if(deal) {
                count++;
                finalSellers += i + " ";
            }
        }
        System.out.println(count);
        System.out.println(finalSellers);
    }

}
