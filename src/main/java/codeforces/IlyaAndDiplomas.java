package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/08/2015.
 */
public class IlyaAndDiplomas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min1 = in.nextInt();
        int max1 = in.nextInt();
        int min2 = in.nextInt();
        int max2 = in.nextInt();
        int min3 = in.nextInt();
        int max3 = in.nextInt();

        int current1 = min1, current2 = min2, current3 = min3;
        int current = n - min1 - min2 - min3;
        while(current > 0) {
            if (current1 < max1) {
                current1++;
                current--;
            } else if (current2 < max2) {
                current2++;
                current--;
            } else if (current3 < max3) {
                current3++;
                current--;
            }
        }
        System.out.println(current1 + " " + current2 + " " + current3);
    }

}
