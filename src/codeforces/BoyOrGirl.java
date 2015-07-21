package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 21/07/2015.
 */
public class BoyOrGirl {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[] charArray = input.toCharArray();
        String output = "";
        int count = 0;
        for(int i=0; i<charArray.length; i++) {
            if(output.indexOf(charArray[i]) == -1) {
                count++;
            }
            output += charArray[i];
        }
        if(count%2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }

    }

}
