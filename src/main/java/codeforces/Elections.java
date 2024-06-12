package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 18/08/2015.
 */
public class Elections {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int candidates = in.nextInt();
        int cities = in.nextInt();
        int[] winnerCities = new int[candidates+1];
        int[] cityWinners = new int[cities+1];
        for(int i=1; i<=cities; i++) {
            int maxIndex = -1, maxNumber = -1;
            for(int j=1; j<=candidates; j++) {
                int votes = in.nextInt();
                if(maxNumber < votes) {
                    maxNumber = votes;
                    maxIndex = j;
                    cityWinners[i] = maxIndex;
                }
            }
            winnerCities[maxIndex]++;
        }
        int winnerIndex = -1, winnerCount = -1;
        for(int i=1; i<winnerCities.length; i++) {
            if(winnerCities[i] > winnerCount) {
                winnerCount = winnerCities[i];
                winnerIndex = i;
            }
        }
        System.out.println(winnerIndex);


    }

}
