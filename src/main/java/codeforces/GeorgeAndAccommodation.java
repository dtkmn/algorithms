package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class GeorgeAndAccommodation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rooms = in.nextInt();
        int count = 0;
        for(int i=0; i<rooms; i++) {
            int p = in.nextInt();
            int q = in.nextInt();
            if((q - p) >= 2) count++;
        }
        System.out.println(count);
    }

}
