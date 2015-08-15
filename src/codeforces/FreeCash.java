package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 24/07/2015.
 */
public class FreeCash {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        int currentServe = 0;
        int past = 0;
        for(int i=0; i<n; i++) {
            int current = in.nextInt()*100 + in.nextInt();
            if(current == past) {
                currentServe++;
            } else {
                currentServe = 1;
            }
            past = current;
            count = Math.max(count, currentServe);
        }
        System.out.println(count);
    }

}
