package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class NewYearCandles {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int hours = a;

        while(a >= b) {
            int extraHours = a/b;
            int remainder = a % b;
            hours += extraHours;
            a = extraHours + remainder;
        }

        System.out.println(hours);


    }

}
