package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class NearlyLuckyNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] charArray = input.toCharArray();
        int count = 0;
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == 52 || charArray[i] == 55) {
                count++;
            }
        }

        if(count == 4 || count == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
