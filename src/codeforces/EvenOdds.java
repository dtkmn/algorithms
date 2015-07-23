package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 23/07/2015.
 */
public class EvenOdds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long pos = in.nextLong();
        long divide = n%2==0?n/2:n/2+1;

        if(pos <= divide) {
            // odd
            System.out.println(2*pos-1);
        } else{
            // even
            pos -= divide;
            System.out.println(2*pos);
        }


    }

}
