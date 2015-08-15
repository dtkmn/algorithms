package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 15/08/2015.
 */
public class AandBandChess {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int black = 0, white = 0;

        for(int i=0; i<8; i++) {
            String line = in.next();
            for(int j=0; j<8; j++) {
                char c = line.charAt(j);
                switch(c) {
                    case 'Q':
                        white += 9;
                        break;
                    case 'R':
                        white += 5;
                        break;
                    case 'B':
                        white += 3;
                        break;
                    case 'N':
                        white += 3;
                        break;
                    case 'P':
                        white += 1;
                        break;
                    case 'q':
                        black += 9;
                        break;
                    case 'r':
                        black += 5;
                        break;
                    case 'b':
                        black += 3;
                        break;
                    case 'n':
                        black += 3;
                        break;
                    case 'p':
                        black += 1;
                        break;
                }
            }
        }
        if(white>black) {
            System.out.println("White");
        } else if(white<black) {
            System.out.println("Black");
        } else {
            System.out.println("Draw");
        }


    }

}
