package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 17/08/2015.
 */
public class GregsWorkout {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int chest = 0, biceps = 0, back = 0;
        // 0, 3, 6
        // 1, 4, 7
        // 2, 5, 8
        for(int i=0; i<n; i++) {
            if(i%3 == 0) chest += in.nextInt();
            if(i%3 == 1) biceps += in.nextInt();
            if(i%3 == 2) back += in.nextInt();
        }

        if(chest > biceps && chest > back) {
            System.out.println("chest");
        } else if(chest < back && biceps < back) {
            System.out.println("back");
        } else {
            System.out.println("biceps");
        }
    }

}
