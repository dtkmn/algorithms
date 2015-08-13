package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 13/08/2015.
 */
public class PlayingWithDice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        int firstWin = 0, secondWin = 0, draw = 0;
        for(int i=1; i<=6; i++) {
            int firstAbs = Math.abs(first - i);
            int secondAbs = Math.abs(second - i);
            if(firstAbs == secondAbs) draw++;
            else if(firstAbs > secondAbs) secondWin++;
            else if(firstAbs < secondAbs) firstWin++;
        }
        System.out.println(firstWin + " " + draw + " " + secondWin);
    }

}
