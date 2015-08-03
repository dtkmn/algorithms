package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 3/08/2015.
 */
public class BlackSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int c3 = in.nextInt();
        int c4 = in.nextInt();

        String games = in.next();
        int calories = 0;
        for(int i=0; i<games.length(); i++) {
            char c = games.charAt(i);
            switch(c) {
                case '1':
                    calories += c1;
                    break;
                case '2':
                    calories += c2;
                    break;
                case '3':
                    calories += c3;
                    break;
                case '4':
                    calories += c4;
            }
        }
        System.out.println(calories);

    }

}
