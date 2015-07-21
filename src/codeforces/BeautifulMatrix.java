package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 21/07/2015.
 */
public class BeautifulMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int oneX = -1, oneY = -1;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(in.nextInt() == 1) {
                    oneX=i;
                    oneY=j;
                    break;
                }
            }
        }

        System.out.println(Math.abs(oneX-2) + Math.abs(oneY-2));
    }

}
