package codeforces;

import java.util.Scanner;

/**
 * Created by datse on 4/08/2015.
 */
public class CaseOfTheZerosAndOnes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String input = in.next();

        int numOne = 0, numZero = 0;
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '1') numOne++;
            else if(input.charAt(i) == '0') numZero++;
        }

        System.out.println(Math.abs(numOne-numZero));

    }

}
