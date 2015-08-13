package codeforces;

import java.util.Scanner;

/**
 * Created by dtkmn on 13/08/2015.
 */
public class LuckyTicket {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();
        int firstHalf = 0, secondHalf = 0;
        for(int i=0; i<n; i++) {
            char c = input.charAt(i);
            if(c != '4' && c != '7') {
                System.out.println("NO");
                return;
            }
            if(i+1 <= n/2) {
                firstHalf += Character.getNumericValue(c);
            } else {
                secondHalf += Character.getNumericValue(c);
            }
        }

        if(firstHalf == secondHalf) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
