package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 20/07/2015.
 */
public class NextRound {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int nextRound = 0;
        int valueOnK = -1;
        for(int i=1; i<=n; i++) {
            int input = in.nextInt();
            if(input > 0) {
                if (i < k) {
                    nextRound++;
                } else if (i == k) {
                    valueOnK = input;
                    nextRound++;
                } else {
                    if (valueOnK == input) {
                        nextRound++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(nextRound);

    }

}
