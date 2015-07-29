package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 29/07/2015.
 */
public class Flowers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flowers = in.nextInt();
        int friends = in.nextInt();
        int prices[] = new int[flowers];
        int sum = 0;
        for(int i=0; i<flowers; i++) {
            prices[i] = in.nextInt();
            sum += prices[i];
        }
        Arrays.sort(prices);
        if(flowers == friends) {
            System.out.println(sum);
            return;
        }
        // Exact price = (numFlowers + 1) * flowerprice
        // Most expensive flower first
        int loop = 0;
        int cost = 0;
        for(int i=flowers-1, j=0; i>=0; i--) {
            cost += (loop + 1) * prices[i];
            if(j==friends-1) {
                j=0; loop++;
            } else {
                j++;
            }
        }
        System.out.println(cost);

    }




}

