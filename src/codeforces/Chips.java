package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/08/2015.
 */
public class Chips {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int walruses = in.nextInt();
        int chips = in.nextInt();
        int i = 0;
        int steps = i%walruses+1;
        while(chips >= steps) {
            chips -= steps;
            i++;
            steps = i%walruses+1;
        }
        System.out.println(chips);
    }

}
