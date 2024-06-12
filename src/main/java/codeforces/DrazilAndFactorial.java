package codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by datse on 6/08/2015.
 */
public class DrazilAndFactorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int digits = in.nextInt();
        String[] index = {"","","2","3","322","5","53","7","7222","7332"};
        String input = in.next();
        String output = "";
        for(int i=0; i<digits; i++) {
            char c = input.charAt(i);
            output += index[Character.getNumericValue(c)];
        }
        char[] charArray = output.toCharArray();
        Arrays.sort(charArray);
        for(int i=charArray.length-1; i>=0; i--) {
            System.out.print(charArray[i]);
        }
    }

}
