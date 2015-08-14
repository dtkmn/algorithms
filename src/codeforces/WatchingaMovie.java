package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 13/08/2015.
 */
public class WatchingaMovie {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int bestMoments = in.nextInt();
        int secondButton = in.nextInt();
        int currentTime = 1, mins = 0;
        for(int i=0; i<bestMoments; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if(start > currentTime) {
                while((start - currentTime) >= secondButton) {
                    currentTime += secondButton;
                }
                mins += (end-currentTime+1);
                currentTime = end+1;
            } else {
                mins += (end-start+1);
                currentTime = end+1;
            }
        }
        System.out.println(mins);

    }

}
