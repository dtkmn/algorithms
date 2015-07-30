package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 30/07/2015.
 */
public class PoliceRecruits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int sum = 0;
        int untreated = 0;
        for(int i=0; i<n; i++) {
            sum += in.nextInt();
            if(sum < 0) {
                untreated++;
                sum = 0;
            }
        }
        System.out.println(untreated);

    }

}
