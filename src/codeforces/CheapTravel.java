package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class CheapTravel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ride = in.nextInt();
        int m = in.nextInt();
        int priceFor1 = in.nextInt();
        int priceForM = in.nextInt();
        int sum = 0;

        double priceAverage = priceForM*1.0/m;
        boolean worth = false;
        if(priceAverage<priceFor1) {
            worth = true;
        }
        while(ride > 0) {
            if(ride >=m && worth) {
                sum += priceForM;
                ride -= m;
            } else if(ride < m && worth && (ride * priceFor1 >= priceForM)) {
                sum += priceForM;
                ride -= m;
            } else {
                sum += priceFor1;
                ride--;
            }
        }
        System.out.println(sum);

    }

}
