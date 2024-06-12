package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 22/07/2015.
 */
public class IsYourHorseshoeOnTheOtherHoof {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] shoes = {0,0,0,0};
        int pos = 0;
        for(int i=0; i<4; i++) {
            int input = in.nextInt();
            boolean found = false;
            for(int j=0; j<4; j++) {
                if(shoes[j] == input) {
                    found = true;
                    break;
                }
            }
            if(!found) shoes[pos++] = input;
        }

        int count = 0;
        for(int k=0; k<4; k++) {
            if(shoes[k] == 0) {
                count++;
            }
        }

        System.out.println(count);

    }

}
