package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 1/08/2015.
 */
public class BusinessTrip {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] months = new int[12];
        for(int i=0; i<12; i++) {
            months[i] = in.nextInt();
        }
        Arrays.sort(months);
        int count = 0;
        int sum = 0;
        for(int j= months.length-1; j>=0; j--) {
            if(sum >= k) break;
            sum += months[j];
            count++;
        }

        if(sum >= k) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

}
