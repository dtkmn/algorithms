package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dtkmn on 2/08/2015.
 */
public class AmrAndMusic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int instruments = in.nextInt();
        int days = in.nextInt();
        int[] learn = new int[instruments+1];
        int[] inpos = new int[instruments+1];

        for(int i=1; i<=instruments; i++) {
            learn[i] = in.nextInt();
        }
        inpos = Arrays.copyOf(learn, learn.length);

        Arrays.sort(learn);

        int j = 1;
        int count = 0;
        String result = "";
        while(days>0 && j < learn.length) {
            int got = learn[j];
            if(got <= days) {
                count++;
                days -= got;

                for(int k=1; k<inpos.length; k++) {
                    if(inpos[k] == got) {
                        result += (k + " ");
                        inpos[k] = -1;
                        break;
                    }
                }
            } else {
                break;
            }
            j++;
        }
        System.out.println(count);
        System.out.println(result.trim());

    }

}
