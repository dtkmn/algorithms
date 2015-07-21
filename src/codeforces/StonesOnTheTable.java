package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class StonesOnTheTable {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input = in.next();

        if(input.length() == 1) {
            System.out.println(0);
            return;
        }

        char[] charArray = input.toCharArray();
        char current = charArray[0];
        int count = 0;
        for(int i=1; i<charArray.length; i++) {
            if(charArray[i] == current) {
                count++;
            } else {
                current = charArray[i];
            }
        }
        System.out.println(count);

    }

}
